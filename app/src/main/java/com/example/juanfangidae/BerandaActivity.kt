package com.example.juanfangidae

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.juanfangidae.DetailActivity

class BerandaActivity : AppCompatActivity() {

    private lateinit var perpustakaanRecyclerView: RecyclerView
    private lateinit var perpustakaanAdapter: MyAdapter1
    private lateinit var listPerpustakaan : ArrayList<ItemData1>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        perpustakaanRecyclerView = findViewById(R.id.perpustakaanRv)
        listPerpustakaan = ArrayList()

        listPerpustakaan.add(ItemData1(R.drawable.buku, "Biologi SMA/MA", "Esis",
            "Buku ini ditujukan untuk siswa kelas XII program studi Ilmu Pengetahuan Alam (IPA) dan disusun" +
                    " berdasarkan Kurikulum Standar Isi 2006. Materinya disajikan dengan bahasa yang lugas dan " +
                    "dilengkapi dengan ilustrasi untuk memudahkan pemahaman siswa terhadap konsep-konsep biologi. " +
                    "Topik-topik yang dibahas mencakup berbagai aspek biologi yang relevan dengan kehidupan " +
                    "sehari-hari, serta dirancang untuk menumbuhkan kemampuan berpikir kritis dan analitis siswa." +
                    "Namun, berdasarkan analisis kelayakan yang dilakukan oleh Universitas Negeri Malang, buku ini" +
                    " memperoleh skor kelayakan isi sebesar 2,26 (56,5%), yang tergolong cukup. Sementara itu, skor" +
                    " kebahasaan mencapai 3,71 (92,75%), menunjukkan kualitas bahasa yang tinggi. Skor penyajian " +
                    "sebesar 2,4 (60%) juga tergolong cukup. Oleh karena itu, disarankan agar pengguna buku ini " +
                    "bersikap selektif dalam memanfaatkan informasinya, dengan mempertimbangkan kelebihan seperti" +
                    " cakupan materi dan bahasa yang komunikatif."))
        listPerpustakaan.add(ItemData1(R.drawable.bukuii, "Laskar Pelangi", "Bentang Pustaka",
            "Laskar Pelangi adalah novel pertama dari tetralogi Andrea Hirata yang mengisahkan kehidupan sepuluh " +
                    "anak dari keluarga miskin di Desa Gantung, Pulau Belitung. Mereka bersekolah di SD Muhammadiyah yang" +
                    " nyaris ditutup karena kekurangan murid. Dengan semangat juang yang tinggi, mereka berusaha " +
                    "mempertahankan sekolah tersebut agar tetap berdiri. Tokoh-tokoh utama dalam novel ini antara lain:" +
                    "Ikal: narator cerita yang mewakili Andrea Hirata " +
                    "sendiri. Lintang: anak jenius yang rela bersepeda puluhan kilometer demi bersekolah. Mahar: anak " +
                    "kreatif dan imajinatif yang sering diremehkan, namun berhasil mengangkat derajat sekolah mereka dalam " +
                    "karnaval 17 Agustus. Novel ini menggambarkan realitas pendidikan di daerah terpencil Indonesia, dengan" +
                    " segala keterbatasannya. Namun, di tengah keterbatasan tersebut, terdapat semangat belajar dan mengajar" +
                    " yang luar biasa."))
        listPerpustakaan.add(ItemData1(R.drawable.bukuiii, "Negara & Revolusi", "Resist Book",
            "Negara dan Revolusi adalah salah satu karya paling penting dari Lenin, yang ditulis pada " +
                    "Agustus–September 1917 menjelang Revolusi Oktober di Rusia. Dalam buku ini, Lenin berupaya" +
                    " memulihkan teori negara dan revolusi proletar sebagaimana yang diajarkan oleh Karl Marx dan" +
                    " Friedrich Engels, yang menurutnya telah diselewengkan oleh kaum borjuis dan oportunis dalam" +
                    " gerakan buruh setelah kematian Marx."))
        listPerpustakaan.add(ItemData1(R.drawable.bukuiv, "Rich Dad Poor Dad", "Warner Books",
            "Rich Dad Poor Dad adalah buku yang mengisahkan pengalaman pribadi Robert T. Kiyosaki yang " +
                    "dibesarkan oleh dua figur ayah dengan pandangan finansial yang kontras. Ayah kandungnya, " +
                    "Poor Dad adalah seorang pendidik yang menekankan pentingnya pendidikan formal dan pekerjaan tetap." +
                    " Sementara itu, ayah dari sahabatnya, \"Rich Dad,\" adalah seorang pengusaha sukses yang " +
                    "mengajarkan pentingnya literasi keuangan, investasi, dan membangun aset."))
        listPerpustakaan.add(ItemData1(R.drawable.bukuv, "Artificial Intelligence", "Pearson",
            "Buku ini dianggap sebagai referensi utama dalam bidang kecerdasan buatan (AI) dan digunakan di " +
                    "lebih dari 1.500 universitas di seluruh dunia. Dirancang untuk mahasiswa sarjana dan pascasarjana," +
                    " buku ini juga cocok bagi profesional yang ingin memahami teori dan praktik AI secara mendalam."))
        listPerpustakaan.add(ItemData1(R.drawable.bukuvi, "Hukum Pidana", "Bumi Aksara",
            "Buku ini membahas secara komprehensif mengenai hukum pidana di Indonesia, dimulai dari pengertian " +
                    "dasar, asas-asas hukum pidana, hingga penerapan hukum pidana dalam praktik. Penulis menguraikan " +
                    "konsep-konsep penting seperti tindak pidana, pertanggungjawaban pidana, dan sistem pemidanaan, serta" +
                    " memberikan analisis terhadap peraturan perundang-undangan yang berlaku. Buku ini dirancang untuk" +
                    " memberikan pemahaman yang mendalam bagi mahasiswa hukum, praktisi, dan siapa saja yang tertarik " +
                    "mempelajari hukum pidana di Indonesia."))

        perpustakaanRecyclerView.layoutManager = LinearLayoutManager(this)
        perpustakaanRecyclerView.setHasFixedSize(true)
        perpustakaanAdapter = MyAdapter1(listPerpustakaan)
        perpustakaanRecyclerView.adapter = perpustakaanAdapter

        perpustakaanAdapter.onItemClick = { selectedItem ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("item", selectedItem)
            startActivity(intent)
        }
    }
}