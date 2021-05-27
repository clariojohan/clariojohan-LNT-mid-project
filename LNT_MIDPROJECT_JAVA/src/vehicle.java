public class vehicle {

	private String vehicleType;
	private String brand;
	private String name;
	private String license;
	private int topSpeed;
	private int gasCapacity;
	private int wheel;
	private String type;
	private int entertain;
	private int helm;

	//setter

	public void setVehicleType(String x){
		this.vehicleType = x;
	}
	public void setBrand(String x){
		this.brand = x;
	}
	public void setName(String x){
		this.name = x;
	}
	public void setLicense(String x){
		this.license = x;
	}
	public void setTopSpeed(int x){
		this.topSpeed = x;
	}
	public void setGasCapacity(int x){
		this.gasCapacity = x;
	}
	public void setWheel(int x){
		this.wheel = x;
	}
	public void setType(String x){
		this.type = x;
	}
	public void setEntertain(int x){
		this.entertain = x;
	}
	public void setHelm(int x){
		this.helm = x;
	}
	
	// getter

	public String getVehicleType(){
		return this.vehicleType;
	}
	public String getBrand(){
		return this.brand;
	}
	public String getName(){
		return this.name;
	}
	public String getLicense(){
		return this.license;
	}
	public int getTopSpeed(){
		return this.topSpeed;
	}
	public int getGasCapacity(){
		return this.gasCapacity;
	}
	public int getWheel(){
		return this.wheel;
	}
	public String getType(){
		return this.type;
	}
	public int getEntertain(){
		return this.entertain;
	}
	public int getHelm(){
		return this.helm;
	}

}
