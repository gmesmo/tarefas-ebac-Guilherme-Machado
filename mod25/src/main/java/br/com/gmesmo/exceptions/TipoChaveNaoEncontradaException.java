package br.com.gmesmo.exceptions;

public class TipoChaveNaoEncontradaException extends Exception {

    private static final long serialVersionUID = 2685707916622679876L;

	public TipoChaveNaoEncontradaException(String msg) {
        this(msg, null);
    }

    public TipoChaveNaoEncontradaException(String msg, Throwable e) {
        super(msg, e);
    }
}
