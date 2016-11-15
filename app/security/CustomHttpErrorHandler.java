package security;

import play.http.HttpErrorHandler;
import play.inject.Injector;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;

import javax.inject.Singleton;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Singleton
public class CustomHttpErrorHandler implements HttpErrorHandler {

    play.inject.Injector injector;

    public CompletionStage<Result> onClientError(Http.RequestHeader request, int statusCode, String message) {
        if(statusCode == play.mvc.Http.Status.NOT_FOUND) {
            UserAuthenticator userAuthenticator = injector.instanceOf(UserAuthenticator.class);
            userAuthenticator.getUsername(Http.Context.current());

        }
        return CompletableFuture.completedFuture(
                Results.status(statusCode, "A client error occurred: " + message)
        );
    }

    public CompletionStage<Result> onServerError(Http.RequestHeader request, Throwable exception) {
        return CompletableFuture.completedFuture(
                Results.internalServerError("A server error occurred: " + exception.getMessage())
        );
    }
}
