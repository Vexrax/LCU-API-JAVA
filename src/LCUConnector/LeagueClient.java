package LCUConnector;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.util.concurrent.CompletableFuture;

public class LeagueClient implements ILeagueClient
{
    /**
     * Used for Creating the connection if you know the location of the league of legends execuatble.
     * @param LeagueExecutablePath Path to the LeagueOfLegends executable
     */
    public LeagueClient(string LeagueExecutablePath)
    {
        HttpClient Client = HttpClientBuilder.create().build();

    }

    /**
     * Used For Creating the connection if you dont know where the League Of Legends executable is
     */
    public LeagueClient()
    {

    }

    public CompletableFuture<LeagueClient> Connect()
    {
        return CompletableFuture();
    }


    public CompletableFuture<HttpResponse> MakeApiRequest(HttpMethod methodType, String endpoint, Object Data) throws RequestTypeNotFoundException
    {
        switch(methodType)
        {
            case Get:
                return CompletableFuture(new HttpResponse);
            case Put:
                return CompletableFuture(new HttpResponse);
            case Post:
                return CompletableFuture(new HttpResponse);
            case Delete:
                return CompletableFuture(new HttpResponse);
            default:
                throw new RequestTypeNotFoundException(methodType);
        }
    }
    public void Disconnect()
    {

    }


}
