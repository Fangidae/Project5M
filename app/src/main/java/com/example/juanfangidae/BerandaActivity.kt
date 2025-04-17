package com.example.juanfangidae

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
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
            "Buku ini dirancang untuk siswa kelas XII SMA/MA yang ingin memahami Biologi secara " +
                    "mendalam. Mengacu pada Kurikulum Tingkat Satuan Pendidikan (KTSP) Standar Isi 2006, " +
                    "buku ini didukung oleh ilustrasi berwarna penuh untuk memudahkan pemahaman."))
        listPerpustakaan.add(ItemData1(R.drawable.bukuii, "Laskar Pelangi", "Bentang Pustaka",
            "Novel ini mengisahkan kehidupan sepuluh anak dari keluarga kurang mampu di Desa Gantung," +
                    " Belitung Timur, yang bersekolah di SD Muhammadiyah—sekolah sederhana yang hampir ditutup " +
                    "karena kekurangan murid. Kedatangan Harun sebagai murid kesepuluh menyelamatkan sekolah " +
                    "tersebut dari penutupan. Anak-anak ini kemudian dikenal sebagai \"Laskar Pelangi\", nama " +
                    "yang diberikan oleh guru mereka, Bu Muslimah, karena kecintaan mereka terhadap pelangi yang" +
                    " sering mereka saksikan bersama."))
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