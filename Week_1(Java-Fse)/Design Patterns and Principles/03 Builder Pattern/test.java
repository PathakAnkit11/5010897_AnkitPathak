public class test {
    public static void main(String[] args) {
        Computer gamingComputer = new Computer.Builder()
            .setCPU("Intel i5")
            .setRAM("32GB")
            .setStorage("1TB SSD")
            .setGPU("NVIDIA RTX 3080")
            .setMotherboard("HP 15")
            .build();
        Computer officeComputer = new Computer.Builder()
            .setCPU("Intel i3")
            .setRAM("16GB")
            .setStorage("512MB SSD")
            .build();
        System.out.println("Gaming Computer: " + gamingComputer);
        System.out.println("Office Computer: " + officeComputer);
    }
}
