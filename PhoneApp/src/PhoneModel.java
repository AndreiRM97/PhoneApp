abstract class PhoneModel {
    protected String model;
    protected String color;
    protected String material;
    protected String imei;
    protected int batteryLife;

    public PhoneModel(String model, String color, String material, String imei, int batteryLife) {
        this.model = model;
        this.color = color;
        this.material = material;
        this.imei = imei;
        this.batteryLife = batteryLife;
    }
}
