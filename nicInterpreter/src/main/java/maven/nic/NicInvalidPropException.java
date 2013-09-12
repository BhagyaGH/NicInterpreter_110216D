package maven.nic;

public class NicInvalidPropException extends Exception {
    
    public NicInvalidPropException() {
		super("NIC number is incorrect!");
    }
}
