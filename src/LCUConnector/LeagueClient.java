package LCUConnector;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.util.concurrent.CompletableFuture;

public class LeagueClient implements ILeagueClient
{
    public LeagueClient()
    {
        HttpClient Client = HttpClientBuilder.create().build();

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
