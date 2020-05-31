package br.com.tokiomarine.seguradora.avaliacao.exception;

public class BusinessException extends Exception{

    private String code;

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
