package com.once.android.testandroid.bus;

/**
 * Base network events
 */
public abstract class BaseNetworkEvent {

    public static final String UNHANDLED_MSG = "UNHANDLED_MSG";
    public static final int UNHANDLED_CODE = -1;


    /**
     * The network call has been completed successfully
     *
     * @param <Rs> Response
     */
    public abstract static class Completed<Rs> {
        private Rs response;

        public Completed(Rs response) {
            this.response = response;
        }

        public Rs getResponse() {
            return response;
        }
    }


    /**
     * The network call has failed
     */
    public abstract static class Error {
        private int statusCode;
        private String errorMessage;

        public Error(int code, String errorMessage) {
            this.statusCode = code;
            this.errorMessage = errorMessage;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }

}
