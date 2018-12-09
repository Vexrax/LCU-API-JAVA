package LCUConnector;

import org.apache.http.HttpResponse;

import java.util.concurrent.CompletableFuture;

public interface ILeagueClient
{
    void Disconnect();
    CompletableFuture<LeagueClient> Connect();
    CompletableFuture<HttpResponse> MakeApiRequest(HttpMethod methodType, String endpoint, Object Data);

}
