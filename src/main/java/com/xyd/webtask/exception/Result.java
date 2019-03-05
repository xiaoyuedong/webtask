package com.xyd.webtask.exception;

public class Result
{
    /**
     * エラー内容
     */
    private String error;

    /**
     * エラーコード
     */
    private int code;


    public Result(String error, int code)
    {
        this.error = error;
        this.code = code;
    }

    public String getError()
    {
        return error;
    }

    public void setError(String error)
    {
        this.error = error;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }


    public enum ErrorCode{
        /**
         * 
         */
        GOODS_NOT_FOUND(40401),

        /**
         * 
         */
        GOODS_ALREADY_EXIST(40001),
        ;

        private int code;

        public int getCode()
        {
            return code;
        }

        ErrorCode(int code)
        {
            this.code = code;
        }
    }
}