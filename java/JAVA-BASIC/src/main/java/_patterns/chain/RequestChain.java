package _patterns.chain;

import java.util.Arrays;
import java.util.List;


class Request {
    public List<String> headers;

    public Request() {
    }

    public Request(List<String> headers) {
        this.headers = headers;
    }

    public static Request of(List<String> headers) {
        return new Request(headers);
    }
}

interface RequestHandler {
    boolean handle(Request request);
}

class BaseHandler implements RequestHandler {

    @Override
    public boolean handle(Request request) {
        List<String> headers = request.headers;
        if (headers.contains("fuck")) {
            return false;
        }
        return true;
    }
}
class ThrottlingHandler implements RequestHandler {
    private int requestPerMinute;
    private int requests;
    private long currentTime;

    public ThrottlingHandler(int requestPerMinute) {
        this.requestPerMinute = requestPerMinute;
        this.currentTime = System.currentTimeMillis();
    }

    @Override
    public boolean handle(Request request) {
        if (System.currentTimeMillis() > currentTime + 60_000) {
            requests = 0;
            currentTime = System.currentTimeMillis();
        }
        requests++;
        if (requests > requestPerMinute) {
            System.out.println("Request limit exceeded!");
            return false;
        }
        return true;
    }
}

class AuthHandler implements RequestHandler {
    @Override
    public boolean handle(Request request) {
        if (!request.headers.contains("Authorization")) {
            return false;
        }
        return true;
    }
}

public class RequestChain {


    public static void main(String[] args) {
        List<RequestHandler> handlers = Arrays.asList(new BaseHandler(), new ThrottlingHandler(2), new AuthHandler());
        Request request = new Request(Arrays.asList("Authorization", "Cookie"));
        for (RequestHandler handler : handlers) {
            boolean success = handler.handle(request);
            if (!success) {
                System.out.println(">>>>");
                return;
            }
        }
    }

}
