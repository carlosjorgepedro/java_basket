package pt.southbank.exceptions;

public class InvalidProduct extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6021095248063740946L;
	private String product;

	public InvalidProduct(String product) {
		this.product = product;
	}

	public String product() {
		return this.product;
	}

}
