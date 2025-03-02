import java.util.ArrayList;
import java.util.Scanner;

class Motor {
    // Enkapsulasi: atribut private
    private String id;
    private String merek;
    private String model;
    private double harga;

    // Konstruktor
    public Motor(String id, String merek, String model, double harga) {
        this.id = id;
        this.merek = merek;
        this.model = model;
        this.harga = harga;
    }

    // Setter dan Getter untuk atribut
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    // Method untuk menampilkan detail motor
    public void displayMotor() {
        String[] atribut = {"ID = "+ id, "Merek = "+ merek, "Model = "+ model, "Harga = "+ harga};
        for (String detail : atribut){
            System.out.println(detail);
        }
    }
}

//Main Menu
public class ManajemenPembelianMotor {
    private static ArrayList<Motor> daftarMotor = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Menu Manajemen Pembelian Motor ===");
            System.out.println("1. Tambah Motor");
            System.out.println("2. Lihat Daftar Motor");
            System.out.println("3. Update Motor");
            System.out.println("4. Hapus Motor");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    tambahMotor();
                    break;
                case 2:
                    lihatDaftarMotor();
                    break;
                case 3:
                    updateMotor();
                    break;
                case 4:
                    hapusMotor();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    // Method untuk menambah motor
    private static void tambahMotor() {
        System.out.println("\n=== Tambah Motor ===");
        System.out.print("Masukkan ID Motor: ");
        String id = scanner.nextLine();
        System.out.print("Masukkan Merek Motor: ");
        String merek = scanner.nextLine();
        System.out.print("Masukkan Model Motor: ");
        String model = scanner.nextLine();
        System.out.print("Masukkan Harga Motor: ");
        double harga = scanner.nextDouble();
        scanner.nextLine(); // Membersihkan buffer

        Motor motor = new Motor(id, merek, model, harga);
        daftarMotor.add(motor);
        System.out.println("Motor berhasil ditambahkan!");
    }

    // Method untuk melihat daftar motor
    private static void lihatDaftarMotor() {
        System.out.println("\n=== Daftar Motor ===");
        if (daftarMotor.isEmpty()) {
            System.out.println("Tidak ada motor yang tersedia.");
        } else {
            for (int i = 0; i < daftarMotor.size(); i++) {
                System.out.println("\nMotor ke-" + (i + 1));
                daftarMotor.get(i).displayMotor();
            }
        }
    }

    // Method untuk mengupdate motor
    private static void updateMotor() {
        System.out.println("\n=== Update Motor ===");
        System.out.print("Masukkan ID Motor yang ingin diupdate: ");
        String id = scanner.nextLine();

        boolean ditemukan = false;
        for (Motor motor : daftarMotor) {
            if (motor.getId().equals(id)) {
                ditemukan = true;
                System.out.println("Data Motor saat ini:");
                motor.displayMotor();

                System.out.print("Masukkan Merek Baru: ");
                String merekBaru = scanner.nextLine();
                System.out.print("Masukkan Model Baru: ");
                String modelBaru = scanner.nextLine();
                System.out.print("Masukkan Harga Baru: ");
                double hargaBaru = scanner.nextDouble();
                scanner.nextLine(); // Membersihkan buffer

                motor.setMerek(merekBaru);
                motor.setModel(modelBaru);
                motor.setHarga(hargaBaru);

                System.out.println("Motor berhasil diupdate!");
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Motor dengan ID " + id + " tidak ditemukan.");
        }
    }

    // Method untuk menghapus motor
    private static void hapusMotor() {
        System.out.println("\n=== Hapus Motor ===");
        System.out.print("Masukkan ID Motor yang ingin dihapus: ");
        String id = scanner.nextLine();

        boolean ditemukan = false;
        for (Motor motor : daftarMotor) {
            if (motor.getId().equals(id)) {
                ditemukan = true;
                daftarMotor.remove(motor);
                System.out.println("Motor dengan ID " + id + " berhasil dihapus.");
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Motor dengan ID " + id + " tidak ditemukan.");
        }
    }
}
