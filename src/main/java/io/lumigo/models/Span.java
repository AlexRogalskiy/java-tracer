package io.lumigo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Locale;

@AllArgsConstructor
@Builder(toBuilder = true)
@Data(staticConstructor = "of")
public class Span {
    private String name;
    private long started;
    private long ended;
    private String runtime;
    private String id;
    private String type;
    private int memoryAllocated;
    private String transactionId;
    private String requestId;
    private String account;
    private int maxFinishTime;
    private String event;
    private String envs;
    private String region;
    private Long reporter_rtt;
    private Error error;
    private String token;
    private String return_value;
    private Info info;
    private String readiness;

    @AllArgsConstructor
    @Builder(toBuilder = true)
    @Data(staticConstructor = "of")
    public static class Info {
        private Tracer tracer;
        private TraceId traceId;
        private String logStreamName;
        private String logGroupName;
        private String triggeredBy;
    }

    @AllArgsConstructor
    @Builder(toBuilder = true)
    @Data(staticConstructor = "of")
    public static class Tracer {
        private String version;
    }

    @AllArgsConstructor
    @Builder(toBuilder = true)
    @Data(staticConstructor = "of")
    public static class TraceId {
        @JsonProperty("Root")
        private String root;
    }

    @AllArgsConstructor
    @Builder(toBuilder = true)
    @Data(staticConstructor = "of")
    public static class Error {
        private String type;
        private String message;
        private String stacktrace;
    }

    public enum READINESS {
        WARM,
        COLD;

        public String toString() {
            return name().toLowerCase(Locale.ENGLISH);
        }
    }
}
