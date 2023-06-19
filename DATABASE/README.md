## App.java
App.java terdapat di dalam folder src, dimana didalam file App.java itu sendiri terdapat 7 baris kode yang didalamnya terdapat:
- import com.layouts.Menu yang bertujuan agar dapat menggunakan class Menu  di class App.

- public class App
-> Dalam kode ini, terdapat kelas App yang memiliki sebuah method bernama 'main'. Method ini merupakan titik awal ketika program Java dieksekusi, dan menerima argumen bertipe String[] dengan nama 'args'.
- Menu.showMenu():
-> "Metode showMenu() dari kelas Menu digunakan untuk menampilkan menu saat program berjalan.
## Com
Terdapat beberapa package yaitu :
1. config
2. controllers
3. layouts
4. models

## 1. config
   MyConfig.java
- import java.sql.Connection; , import java.sql.DriverManager; , import java.sql.PreparedStatement; , import java.sql.ResultSet; dan import java.sql.SQLException;
    Mengimpor kelas-kelas(Connection, DriverManager, PreparedStatement, ResultSet, dan SQLException) untuk mengakses dan mengelola DataBase.
- public class MyConfig
    Dalam kode ini, terdapat definisi kelas MyConfig yang berfungsi sebagai konfigurasi untuk mengakses database
- private static final String DB_URL
    Bertujuan untuk menghubungkan kedatabase, di sini URL JDBC yang di gunakan adalah "jdbc:mysql://localhost:3306/db_myshop"
- private static final String DB_USER 
    yang bertujuan untuk memproses koneksi ke database, yang terdapat nama pengguna yaitu "root".
- private static final String DB_PASS 
    Variabel ini berisi password yang akan digunakan untuk memproses koneksi ke database. Di dalam kode tersebut terdapat password kosong (" ").
- Variabel terkait dengan DataBase
    Dalam kode ini, terdapat beberapa variabel yang berkaitan dengan database. connection merupakan objek Connection yang digunakan untuk mengelola koneksi dengan database. preparedStatement merupakan objek PreparedStatement yang digunakan untuk mengeksekusi pernyataan SQL yang telah diprepare sebelumnya. resultSet merupakan objek ResultSet yang menyimpan hasil dari kueri database. Terakhir, query adalah sebuah string yang berisi pernyataan SQL yang akan dieksekusi dalam database.
- Method Connection
    Method Connection ini digunakan untuk membuat koneksi ke database dengan menggunakan informasi yang disediakan dalam variabel konfigurasi. Di dalamnya, terdapat blok try-catch yang menangkap pengecualian SQLException. Jika koneksi berhasil, pesan 'Database Connected Success' akan dicetak ke konsol. Namun, jika terjadi kesalahan, pengecualian SQLException akan dicetak.

## 2. controllers
    Controllers pada bagian ini merupakan bagian package
    DbController.java pada bagian ini merupakan java class yang dimana turunan dari kelas MYConfig. 
- public static Produk getProdukByNama(String name)
    Method getProdukByNama ini menerima parameter name yang merupakan nama produk, dan mengembalikan objek Produk. Di dalam kode ini, terdapat deklarasi objek produk yang diinisialisasi dengan null.
- public static boolean insertData(String name, long harga, int jumlah)
    Method ini menerima parameter name, harga, dan jumlah untuk memasukkan data produk baru ke dalam database.
- public static void updateNama(int id, String name)
    Method ini menerima dua parameter, yaitu id dan name, yang digunakan untuk mengupdate nama produk dalam database berdasarkan ID.
- public static void updateHarga(int id, long harga)
    Method ini menerima parameter id dan harga untuk mengupdate harga produk dalam database berdasarkan ID. 
- public static void updateStok(int id, int jumlah)
    Method ini menerima parameter id dan jumlah untuk mengupdate stok produk dalam database berdasarkan ID. 
- public static boolean deleteData(int id)
    Method static yang berfungsi untuk menghapus data produk dari database.

## 3. layouts
1. Delete.java
    Kode pada class Delete ini berfungsi untuk menampilkan pilihan data yang ingin dihapus.
2. Edit.java
    Edit.java untuk mengedit data yang ada. 
3. Insert.java
    Insert.java untuk menambahkan data baru ke dalam data yang yang sudah ada.
4. Menu.java
    Menu.java untuk menampilkan output
5. Read.java
   Read.java untuk membaca data yang ada.

## 4. models ini merupakan bagian package
1. Produk.java
    pada bagian ini merupakan bagian darin java class