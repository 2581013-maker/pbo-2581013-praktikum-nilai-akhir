import java.util.Scanner;

public class NilaiAkhir {

    // Empat bobot disimpan sebagai konstanta double, bukan diketik langsung di rumus
    static final double BOBOT_PRAKTIKUM = 0.30;
    static final double BOBOT_TUGAS     = 0.20;
    static final double BOBOT_MID       = 0.20;
    static final double BOBOT_FINAL     = 0.30;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Dibaca sebagai double (nextDouble) supaya input seperti 79.5 tetap diterima
        System.out.print("Nilai praktikum : ");
        double praktikum = input.nextDouble();
        System.out.print("Nilai tugas     : ");
        double tugas = input.nextDouble();
        System.out.print("Nilai MID       : ");
        double mid = input.nextDouble();
        System.out.print("Nilai final     : ");
        double finalNilai = input.nextDouble();

        // Kurung tidak dibutuhkan karena * (perkalian) sudah dikerjakan lebih dulu daripada + oleh Java, sesuai operator precedence
        double akhir = praktikum * BOBOT_PRAKTIKUM + tugas * BOBOT_TUGAS + mid * BOBOT_MID;
        akhir += finalNilai * BOBOT_FINAL; // augmented assignment untuk komponen final

        // --- Percobaan versi bilangan bulat (int), sesuai poin 2 ---
        int pInt = (int) praktikum, tInt = (int) tugas, mInt = (int) mid, fInt = (int) finalNilai;
        int akhirInt = pInt * 30 / 100 + tInt * 20 / 100 + mInt * 20 / 100 + fInt * 30 / 100;
        // Dengan contoh 85/78/70/80, hasilnya 78, bukan 79.1 seperti versi double.
        // Sebabnya: setiap suku (mis. tugas*20/100) adalah PEMBAGIAN BILANGAN BULAT,
        // jadi Java memotong pecahannya ke bawah SEBELUM suku-suku itu dijumlahkan
        // (78*20/100 = 15.6 dipotong jadi 15, dst). Ini bukan salah hitung, tapi karena
        // int sama sekali tidak bisa menyimpan pecahan — jebakan yang sama dengan
        // kasus 1024 vs 1024.0 minggu lalu.

        // Pembulatan ditulis eksplisit; keduanya dibandingkan dengan selisihnya
        int dipotong = (int) akhir;          // memotong ke arah nol - pecahan dibuang
        long dibulatkan = Math.round(akhir); // ke bilangan bulat terdekat
        double selisih = akhir - dibulatkan; // selisih ini bukan salah hitung,
        // melainkan cara double menyimpan pecahan

        // Status kelulusan sebagai boolean, tanpa if
        boolean lulus = akhir >= 60;

        System.out.println();
        System.out.println("===== NILAI AKHIR =====");
        System.out.println("Praktikum : " + praktikum + " (30%)");
        System.out.println("Tugas     : " + tugas + " (20%)");
        System.out.println("MID       : " + mid + " (20%)");
        System.out.println("Final     : " + finalNilai + " (30%)");
        System.out.println();
        System.out.println("Nilai akhir (double) : " + akhir);
        System.out.println("Nilai akhir (int)    : " + akhirInt + "  <- versi percobaan bilangan bulat");
        System.out.println("Dipotong   (int)     : " + dipotong);
        System.out.println("Dibulatkan (round)   : " + dibulatkan);
        System.out.println("Selisih              : " + selisih);
        System.out.println("Lulus (>=60)         : " + lulus);
    }
}
