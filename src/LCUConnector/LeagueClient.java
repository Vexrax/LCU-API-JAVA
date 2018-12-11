package LCUConnector;


import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.RequestDefaultHeaders;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;



public class LeagueClient
{
    String Token;
    String ApiUri;
    int Port;
    int LeaguePID;

    private HttpClient Client;
    byte[] EncodedAuth;
    HttpPost httpost;
    HttpGet httpget;


    /**
     * Used for Creating the connection if you know the location of the league of legends execuatble.
     * @param LeagueExecutablePath Path to the LeagueOfLegends executable
     */
    public LeagueClient(String LeagueExecutablePath)
    {
        this.Client =  HttpClientBuilder.create().build();
        GetLockFileCredintials("C:\\Riot Games\\League of Legends\\lockfile");
        tempMakeReq();
    }

    /**
     * Used For Creating the connection if you dont know where the League Of Legends executable is
     */
    public LeagueClient()
    {

    }

    public void tempMakeReq()
    {
        try
        {
            this.httpget =  new HttpGet(ApiUri + "lol-maps/v1/maps");
            this.httpget.setHeader("Accept", "application/json");
            httpget.setHeader("Content-type", "application/json");
            httpget.setHeader("Authorization", "Basic " +  this.EncodedAuth);
            HttpResponse response = this.Client.execute(httpget);
             
            HttpEntity entity = response.getEntity();
            Header encodingHeader = entity.getContentEncoding();

            // you need to know the encoding to parse correctly
            Charset encoding = encodingHeader == null ? StandardCharsets.UTF_8 :
                    Charsets.toCharset(encodingHeader.getValue());

            // use org.apache.http.util.EntityUtils to read json as string
            String json = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            System.out.println(json);
        }

        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    //public CompletableFuture<LeagueClient> Connect()
    //{
    //    return CompletableFuture();
    //}


//    public CompletableFuture<HttpResponse> MakeApiRequest(HttpMethod methodType, String endpoint, Object Data) throws RequestTypeNotFoundException
//    {
//        switch(methodType)
//        {
//            case Get:
//                return CompletableFuture(new HttpResponse);
//            case Put:
//                return CompletableFuture(new HttpResponse);
//            case Post:
//                return CompletableFuture(new HttpResponse);
//            case Delete:
//                return CompletableFuture(new HttpResponse);
//            default:
//                throw new RequestTypeNotFoundException(methodType);
//        }
//    }

    public void Disconnect()
    {

    }
    private void GetLockFileCredintials(String PathToLockFile)
    {
        BufferedReader reader;
        try
        {
            reader = new BufferedReader(new FileReader(PathToLockFile));
            String line = reader.readLine();
            String[] items = line.split(":");
            this.Token = items[3];
            this.Port = Integer.parseInt(items[2]);
            this.ApiUri = "https://127.0.0.1:" + this.Port + "/";
            this.LeaguePID = Integer.parseInt(items[1]);

            System.out.println(this.Token);
            System.out.println(this.Port);
            System.out.println(this.ApiUri);
            System.out.println(this.LeaguePID);

            String auth = "riot" + ":" + this.Token;
            this.EncodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));


        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

}
