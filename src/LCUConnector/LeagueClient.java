package LCUConnector;

import com.sun.deploy.net.HttpResponse;

import java.util.concurrent.CompletableFuture;

public class LeagueClient
{
    public CompletableFuture<HttpResponse> MakeApiRequest(HttpMethod methodType, String endpoint, Object Data) throws RequestTypeNotFoundException
    {
        switch(methodType)
        {
            case Get:
                return CompletableFuture.completedFuture(new HttpResponse);
            case Put:
                return CompletableFuture.completedFuture(new HttpResponse);
            case Post:
                return CompletableFuture.completedFuture(new HttpResponse);
            case Delete:
                return CompletableFuture.completedFuture(new HttpResponse);
            default:
                throw new RequestTypeNotFoundException(methodType);
        }
    }

}
