package com.thorin.moviecotalogue.utils

import com.thorin.moviecotalogue.data.MovieEntity
import com.thorin.moviecotalogue.data.TvShowEntity

object DataHelper {

    fun generateDataMovie(): ArrayList<MovieEntity> {
        val movie = ArrayList<MovieEntity>()

        movie.add(
            MovieEntity(
                "M1",
                "Star Wars: Episode VIII – The Last Jedi",
                "December 13, 2017",
                "Rating: 7/10 · \u200E572,922 votes",
                "Star Wars: The Last Jedi melanjutkan kisah Rey yang dikirim dalam misi untuk menemukan Luke di Acht-To, tempat kuil Jedi pertama kali didirikan. The Last Jedi juga akan membahas lebih lanjut hubungan antara Kylo Ren dan Rey. Rey meyakini kalau Kylo Ren masih memiliki sisi baik dalam dirinya, bahwa ia tak sepenuhnya gelap. Rey berusaha untuk menarik Kylo Ren ke sisi terang dan membelot dari Snoke. Bagi para fans Star Wars, tentu kamu wajib menonton The Last Jedi. Bagi kamu yang tidak mengikuti Star Wars dari awal, film ini tetap bisa dinikmati untuk penggemar film action.",
                "Science Fiction",
                "Amerika Serikat",
                "https://i.ibb.co/Y2RN0wk/gwigwi-com-last-jedi-header.jpg"
            )
        )

        movie.add(
            MovieEntity(
                "M2",
                "Wall-E",
                "August 13, 2008",
                "Rating: 8.4/10 · \u200E1,013,659 votes",
                "Star Wars: The Last Jedi melanjutkan kisah Rey yang dikirim dalam misi untuk menemukan Luke di Acht-To, tempat kuil Jedi pertama kali didirikan. The Last Jedi juga akan membahas lebih lanjut hubungan antara Kylo Ren dan Rey. Rey meyakini kalau Kylo Ren masih memiliki sisi baik dalam dirinya, bahwa ia tak sepenuhnya gelap. Rey berusaha untuk menarik Kylo Ren ke sisi terang dan membelot dari Snoke. Bagi para fans Star Wars, tentu kamu wajib menonton The Last Jedi. Bagi kamu yang tidak mengikuti Star Wars dari awal, film ini tetap bisa dinikmati untuk penggemar film action. Suatu hari, Eve, sebuah robot modern datang dan merubah hari-hari Wall-E. Eve memiliki misi untuk mencari tahu apakah bumi masih aman untuk ditinggali manusia dan ia menyadari bahwa Wall-E adalah kunci dari misinya tersebut. Hingga Eve menemukan tanaman yang dirawat Wall-E dan secara otomatis kembali ke luar angkasa untuk melaporkan kepada manusia. Wall-E yang tidak mengerti mengikutinya hingga ke luar angkasa.",
                "Science Fiction, Romantic, Comedy, Cartoon",
                "Amerika Serikat",
                "https://ekostoriesdotcom.files.wordpress.com/2013/04/wall-e-stargazing1.jpg?w=840"
            )
        )

        movie.add(
            MovieEntity(
                "M3",
                "The Space Between Us",
                "December 1, 2017",
                "Rating: 6.4/10 · \u200E49,018 votes",
                "The Space Between Us merupakan film sci-fi bernuansa romance dimana, Gardner Elliot adalah orang pertama yang lahir di planet Mars. Tumbuh di Mars, Gardner yang menginjak usia 16 tahun memiliki intelektual yang tinggi dan rasa ingin tahu yang tinggi hingga akhirnya ia bertemu dengan Tulsa dari Colorado secara online. Sampai akhirnya ia mendapatkan kesempatan untuk berkunjung ke bumi akan tetapi, ternyata para peneliti menemukan bahwa organ tubuh Gardner tidak dapat bertahan dengan atmosfer bumi. Bagi para penyuka film science fiction dan romance, film ini bisa masuk ke dalam daftarmu.",
                "Romance, Adventure, Science Fiction, Adventure, Drama",
                "New Mexico",
                "https://www.greeners.co/wp-content/uploads/2017/04/Ulasan-The-Space-Between-Us.jpg"
            )
        )

        movie.add(
            MovieEntity(
                "M4",
                "Thor: Ragnarok",
                "October 25, 2017",
                "Rating: 7.9/10 · \u200E606,476 votes",
                "Bagi pecinta Marvel Cinematic Universe siapa yang tidak mengetahui tokoh Thor? Film dari salah satu tokoh Marvel ini tentunya tidak akan dilewatkan bagi penggemarnya. Merupakan sekuel ketiga dari film Thor sebelumnya, kali ini pada film Thor: Ragnarok memberikan sentuhan komedi yang lebih banyak dari sebelumnya. Thor terkurung di planet Sakaar tanpa palunya dan harus segera kembali ke tempat asalnya, Asgard. Ia harus kembali untuk menyelamatkan Asgard dan menghentikan kehancuran tempat tinggalnya tersebut dari tangan Hela yang kuat dan kejam. Tetapi, sebelumnya, ia harus bertahan dari kontes gladiator dan melawan temannya sendiri sang Incredible Hulk. Aksi dewa petir yang diperankan Chris Hemsworth ini akan membawa keseruan ditambah komedi yang diselipkan di dalamnya. Penampilan Thor pun berbeda dari penampilan pada film Thor sebelumnya. Pastinya seru!",
                "Action, Science Fiction, Buddy, Comedy, Fantasy, Superhero, Adventure",
                "Australia",
                "https://e.rpp-noticias.io/normal/2017/11/07/161516_515305.jpg"
            )
        )

        movie.add(
            MovieEntity(
                "M5",
                "Your Name",
                "December 7, 2016",
                "Rating: 8.4/10 · \u200E204,783 votes",
                "Kimi no Na wa bercerita seputar kehidupan seorang gadis bernama Mitsuha Miyamizu dan seorang anak lelaki bernama Taki Tachibana. Mitsuha adalah anak dari desa sementara Taki tinggal di tengah kota Tokyo. Terkadang mereka bermimpi seperti sedang bertukar jiwa, tetapi lama-kelamaan mimpi itu terasa semakin nyata. Saat mereka sadar bahwa mereka berdua tidak bermimpi, mereka mulai membuat buku harian untuk melaporkan kejadian yang mereka alami saat bertukar tempat. Suatu hari, fenomena pertukaran ini pun tersebut berhenti. Perasaan resah dan cinta yang timbul di dalam hati membuat mereka berusaha mencari keberadaan satu sama lain. Cerita tersebut dikatakan terinspirasi dari dongeng tua di Jepang yang menceritakan tentang dua bersaudara lelaki dan perempuan. Karena kepribadiannya, si anak lelaki dibesarkan seperti perempuan sedangkan si anak perempuan dibesarkan seperti lelaki. Selain dongeng, ada juga puisi tentang mimpi yang menginspirasi elemen di mana mereka berdua bertukar setelah terbangun dari tidur, layaknya orang yang bermimpi. Tema cerita yang familiar seperti inilah yang berhasil membuat Kimi no Na wa diterima dengan baik oleh penonton Jepang.",
                "Anime, Animation, Drama, Romance, Fantasy",
                "Jepang",
                "https://idkurir.web.id/wp-content/uploads/2016/12/Review-Kimi-no-Na-Wa.jpg"
            )
        )

        movie.add(
            MovieEntity(
                "M6",
                "Weathering With You",
                "August 21, 2019",
                "Rating: 7.5/10 · \u200E25,331 votes",
                "Seorang anak muda dari desa terpencil di Shikoku bernama Hodaka (Kotaro Daigo) yang meninggalkan rumah dan memutuskan untuk tinggal di Tokyo. Dalam perjalanannya, dia bertemu dengan Keisuke (Shun Oguri), seorang pria aneh di kapal yang sempat menyelamatkannya. Kei pun menawarkan bantuan kepada Hodaka dengan memberikan kartu nama. Sesampainya di Tokyo, Hodaka menghadapi kesulitan yang datang silih berganti dalam perjalanannya. Setelah beberapa kali tidur di jalanan karena tidak ada orang lain yang bisa dihubungi. Kehabisan uang dan bingung harus bagaimana, Hodaka memutuskan untuk menghubungi Keisuke. Hodaka mendapatkan tawaran bekerja sebagai penulis majalah lokal milik Keisuke yang membahas supernatural dan hal-hal aneh. Selama di Tokyo, Hodaka selalu diikuti cuaca aneh di mana hujan turun tiada henti. Saat menulis sebuah cerita, dia mendengar kisah pengendali cuaca alias gadis sinar matahari. Dia berusaha mencari kebenaran dari legenda urban di mana ada seorang gadis muda yang memiliki kekuatan untuk menghentikan hujan dan membuat langit menjadi cerah kembali. Pencariannya ini membuatnya bertemu dengan Hina Amano (Nana Mori), seorang gadis yang memiliki kekuatan luar biasa yang dapat mengendalikan cuaca. ",
                "Anime, Fantasy, Disaster, Romance, Drama, Animation, Teen",
                "Jepang",
                "https://twinfinite.net/wp-content/uploads/2019/04/weatheringwithyou1.jpg"
            )
        )

        movie.add(
            MovieEntity(
                "M7",
                "The Garden Of Words",
                "April 28, 2013",
                "Rating: 7.5/10 · \u200E36,283 votes",
                "Film ini menceritakan tentang seorang anak SMA bernama Takao Akizuki, yang memiliki kebiasaan yaitu ketika hujan ia bolos sekolah dan pergi ke sebuah taman. Suatu hari, di gazebo taman tersebut, ia melihat seorang wanita berpakaian kantoran. Takao suka mendesain dan membuat sepatu. Ia mempunyai cita-cita untuk menjadi seorang pembuat sepatu. Di gazebo tersebut, Takao menghabiskan waktunya dengan melakukan hobby-nya. Tidak sekali atau dua kali, tetapi setiap Takao pergi ke gazebo taman, ia selalu bertemu dengan wanita tersebut. Pada akhirnya mereka pun berkenalan, mulai bertukar nama, dan mulai berbincang satu sama lain. Seiring berlalunya waktu, musim hujan pun mulai berakhir dan Takao sudah tidak mempunyai alasan lagi untuk pergi ke gazebo. Tentu saja cerita film ini tidak berakhir disitu. Sejujurnya, saya bukanlah penggemar cerita romansa. Namun ajaibnya saya tertarik dengan film ini. Film ini tidak mempunyai plot cerita yang kompleks, tetapi itulah hebatnya Makoto Shinkai. Ia berhasil membuat penonton jatuh cinta pada kisah yang sederhana. Hal lain yang membuat saya jatuh cinta pada karya Makoto Shinkai adalah ilustrasi latar belakang dan penggunaan tema warnanya. Di dalam film The Garden of Words ini pun, mata saya tidak bisa berhenti dari detail-detail yang ditunjukkan. Dimulai dari tetesan hujan, daun-daun yang berayun pelan, bangunan gedung di kota yang menjulang tinggi, kereta yang berlaju cepat, dan penggunaan warna hijau atau biru yang memberi kesan hangat. Sekali lagi, Makoto Shinkai sukses menunjukkan keindahan visual. Musik yang dimainkan juga sangat cocok dengan nuansa hangat dalam film. Musik-musiknya lebih mengarah pada musik klasikal atau orkestra.",
                "Drama, Romance, Anime",
                "Jepang",
                "https://i.pinimg.com/originals/39/b3/ef/39b3ef5a8cae33b2f3a0cee1b5e7906d.png"
            )
        )

        movie.add(
            MovieEntity(
                "M8",
                "A Whisker Away",
                "June 18, 2020",
                "Rating: 6.7/10 · \u200E5,975 votes",
                "Miyo Sasaki, biasa dipanggil Muge oleh teman-teman sekelasnya, hanyalah seorang gadis SMP biasa yang ingin dinotis oleh orang yang ia sukai, Kento Hinode, seorang pemuda yang kebetulan ada di kelas yang sama dengannya. Karena kepribadiannya yang eksentrik dan heboh, serta cara-caranya dalam mendekati Hinode yang tidak biasa, pemuda itu selalu menganggap Muge sebagai gangguan yang seringkali membuatnya malu. Padahal, dalam lubuk hati Muge, ia sangat ingin menyatakan perasaannya pada Hinode. Sayangnya, ia terlalu takut untuk melakukan itu. Akhirnya, dengan topeng yang diberikan kepadanya oleh sesosok kucing bernama Si Penjual Topeng (Men-ya dalam filmnya), ia dapat berubah menjadi seekor kucing kecil berwarna putih yang dapat mendekati Hinode sepuasnya. Jika ia terus-terusan memakai topeng kucing itu, ada kemungkinan Muge dapat berubah menjadi seekor kucing betulan. Dengan kata lain, Muge tidak bisa terus-terusan bersembunyi di balik wujud kucingnya dan ia harus segera menyatakan perasaan yang sesungguhnya kepada Hinode. Bisakah ia melakukan itu?",
                "Romance, Fantasy, Anime",
                "Jepang",
                "http://pm1.narvii.com/7595/b9fe0b1fc99f28d1542007f643ec90755c642bf3r1-696-391v2_uhq.jpg"
            )
        )

        movie.add(
            MovieEntity(
                "M9",
                "Ip Man 4: The Finale",
                "December 28, 2019",
                "Rating: 7.1/10 · \u200E25,769 votes",
                "Setelah kematian istrinya, Ip Man yang berstatus duda harus menerima kenyataan bahwa hubungan dengan putranya lama-lama kian berjarak. Sebagai orangtua, dia kemudian mencari jalan agar kehidupan putranya lebih baik. Dia lantas memutuskan untuk pergi ke Amerika dengan berbekal tiket pesawat yang diberikan oleh salah satu murid Bruce Lee yang datang menemuinya di Hong Kong. Gara-gara membutuhkan surat rekomendasi untuk putranya, bukan sambutan hangat yang dia terima melainkan sambutan perseturuan dari Kepala Asosiasi Kebijakan China Wan Zhonghua (Wu Yue). Wan kecewa dengan Lee yang mengajarkan ilmu bela diri Tiongkok kepada orang Amerika, karena dianggap enggak etis. Berawal dari situ, Ip Man harus meredakan ketegangan di antara para master ilmu bela diri lokal dengan muridnya, Lee, sambil mengadu nasib mencari masa depan untuk putranya. Lewat film besutan Yip, kalian juga bakal disuguhkan drama antara ayah dan anak. Harus diakui, konflik antara Ip dengan sang anak sangat menyentuh di hati. Pasalnya, putranya enggak mengetahui kalau ayahnya sedang mengadu nasib di negara lain sambil melawan penyakit kanker. membuat unsur drama lebih terasa dalam film ini.",
                "Action, History, Martial Arts, Drama",
                "Tiongkok Dan Amerika Serikat",
                "https://www.biem.co/wp-content/uploads/2019/12/ip-man-4.jpg"
            )
        )

        movie.add(
            MovieEntity(
                "M10",
                "Peninsula",
                "October 21, 2020",
                "Rating: 5.5/10 · \u200E22,802 votes",
                "Siapa yang penasaran sama film satu ini? Next Entertainment World dan RedPeter Film akhirnya merilis trailer pertama film Train to Busan 2 Peninsula tanggal 2 April 2020 lalu. Latar waktu yang dipilih adalah 4 tahun setelah kejadian Train to Busan. Kota Busan terlihat seperti kota mati, penduduk habis diserang oleh zombie. Jika di film pertama yang tokoh utama diperankan oleh Gong Yoo, kali ini tokoh utama Jung Seok diperankan oleh Dong Won. Jung Seok adalah mantan angkatan bersenjata yang datang ke Busan untuk sebuah misi. Bukannya dapat sambutan hangat dari keluarga, ia justru harus melawan pasukan zombie.",
                "Horror, Thriller, Adventure, Action, Drama, Suspense",
                "Korea Selatan",
                "https://assets.pikiran-rakyat.com/crop/0x0:0x0/x/photo/2020/07/15/2720963019.jpg"
            )
        )

        return movie

    }

    fun generateDataTvShow(): List<TvShowEntity> {
        val tvShow = ArrayList<TvShowEntity>()

        tvShow.add(
            TvShowEntity(
                "T1",
                "Game of Thrones",
                "April 17, 2011",
                "Rate Tinggi",
                """
                    Game of Throne bisa dibilang sebagai tv series terbaik dalam satu dekade terakhir. Hal itu dirasa tidak berlebihan, karena tv series garapan David Bennioff dan D.B. Weiss sukses merebut perhatian jutaan orang di seluruh dunia. Terbukti serial tv ini sukses mendapatkan rating tertinggi di situs IMDB, yaitu 9,5.
                    Secara garis besar, tv series ini berkisah tentang perebutan tahta kekuasaan diantara para keluarga. Bahkan mereka sampai mempertaruhkan nyawa untuk mendapatkan tahta yang mereka idam-idamkan.
                    Jalan cerita yang kompleks, imajinasi cerita liar, dan eksekusi apik membuat tv series yang dibintangi oleh Emilia Clarke, Kit Harrington, Sophie Turner, dan Lena Headey ini pantas menerima predikat tv series terbaik.
                    Bulan April mendatang, tv series yang diangkat dari novel berjudul A Song of Ice and Fire ini akan mencapai di musim ke-8, yang merupakan musim terakhir dari Game of Thrones. Jadi jika kamu belum menyaksikan tv series ini, kamu bisa marathon Game of Thrones sampai sebelum berkahirnya perjalanan Jon Snow.
                """.trimIndent(),
                "Serial, Epic, Tragedy, Action, Fantasy television, Action fiction, Drama, Suspense, Medieval fantasy, Thriller, Adventure, Special Interest",
                "Northern Ireland Dan Iceland",
                "73 Episode",
                "https://s4.bukalapak.com/uploads/content_attachment/9ef1d7fc30e8d7627da004c5/w-744/tv_series_terbaik_-1.jpg"
            )
        )

        tvShow.add(
            TvShowEntity(
                "T2",
                "Game of hahay",
                "April 17, 2011",
                "Rate Tinggi",
                """
                    Game of Throne bisa dibilang sebagai tv series terbaik dalam satu dekade terakhir. Hal itu dirasa tidak berlebihan, karena tv series garapan David Bennioff dan D.B. Weiss sukses merebut perhatian jutaan orang di seluruh dunia. Terbukti serial tv ini sukses mendapatkan rating tertinggi di situs IMDB, yaitu 9,5.
                    Secara garis besar, tv series ini berkisah tentang perebutan tahta kekuasaan diantara para keluarga. Bahkan mereka sampai mempertaruhkan nyawa untuk mendapatkan tahta yang mereka idam-idamkan.
                    Jalan cerita yang kompleks, imajinasi cerita liar, dan eksekusi apik membuat tv series yang dibintangi oleh Emilia Clarke, Kit Harrington, Sophie Turner, dan Lena Headey ini pantas menerima predikat tv series terbaik.
                    Bulan April mendatang, tv series yang diangkat dari novel berjudul A Song of Ice and Fire ini akan mencapai di musim ke-8, yang merupakan musim terakhir dari Game of Thrones. Jadi jika kamu belum menyaksikan tv series ini, kamu bisa marathon Game of Thrones sampai sebelum berkahirnya perjalanan Jon Snow.
                """.trimIndent(),
                "Serial, Epic, Tragedy, Action, Fantasy television, Action fiction, Drama, Suspense, Medieval fantasy, Thriller, Adventure, Special Interest",
                "Northern Ireland Dan Iceland",
                "73 Episode",
                "https://s4.bukalapak.com/uploads/content_attachment/9ef1d7fc30e8d7627da004c5/w-744/tv_series_terbaik_-1.jpg"
            )
        )

        tvShow.add(
            TvShowEntity(
                "T3",
                "Game of Thrones",
                "April 17, 2011",
                "Rate Tinggi",
                """
                    Game of Throne bisa dibilang sebagai tv series terbaik dalam satu dekade terakhir. Hal itu dirasa tidak berlebihan, karena tv series garapan David Bennioff dan D.B. Weiss sukses merebut perhatian jutaan orang di seluruh dunia. Terbukti serial tv ini sukses mendapatkan rating tertinggi di situs IMDB, yaitu 9,5.
                    Secara garis besar, tv series ini berkisah tentang perebutan tahta kekuasaan diantara para keluarga. Bahkan mereka sampai mempertaruhkan nyawa untuk mendapatkan tahta yang mereka idam-idamkan.
                    Jalan cerita yang kompleks, imajinasi cerita liar, dan eksekusi apik membuat tv series yang dibintangi oleh Emilia Clarke, Kit Harrington, Sophie Turner, dan Lena Headey ini pantas menerima predikat tv series terbaik.
                    Bulan April mendatang, tv series yang diangkat dari novel berjudul A Song of Ice and Fire ini akan mencapai di musim ke-8, yang merupakan musim terakhir dari Game of Thrones. Jadi jika kamu belum menyaksikan tv series ini, kamu bisa marathon Game of Thrones sampai sebelum berkahirnya perjalanan Jon Snow.
                """.trimIndent(),
                "Serial, Epic, Tragedy, Action, Fantasy television, Action fiction, Drama, Suspense, Medieval fantasy, Thriller, Adventure, Special Interest",
                "Northern Ireland Dan Iceland",
                "73 Episode",
                "https://s4.bukalapak.com/uploads/content_attachment/9ef1d7fc30e8d7627da004c5/w-744/tv_series_terbaik_-1.jpg"
            )
        )

        tvShow.add(
            TvShowEntity(
                "T4",
                "Game of Thrones",
                "April 17, 2011",
                "Rate Tinggi",
                """
                    Game of Throne bisa dibilang sebagai tv series terbaik dalam satu dekade terakhir. Hal itu dirasa tidak berlebihan, karena tv series garapan David Bennioff dan D.B. Weiss sukses merebut perhatian jutaan orang di seluruh dunia. Terbukti serial tv ini sukses mendapatkan rating tertinggi di situs IMDB, yaitu 9,5.
                    Secara garis besar, tv series ini berkisah tentang perebutan tahta kekuasaan diantara para keluarga. Bahkan mereka sampai mempertaruhkan nyawa untuk mendapatkan tahta yang mereka idam-idamkan.
                    Jalan cerita yang kompleks, imajinasi cerita liar, dan eksekusi apik membuat tv series yang dibintangi oleh Emilia Clarke, Kit Harrington, Sophie Turner, dan Lena Headey ini pantas menerima predikat tv series terbaik.
                    Bulan April mendatang, tv series yang diangkat dari novel berjudul A Song of Ice and Fire ini akan mencapai di musim ke-8, yang merupakan musim terakhir dari Game of Thrones. Jadi jika kamu belum menyaksikan tv series ini, kamu bisa marathon Game of Thrones sampai sebelum berkahirnya perjalanan Jon Snow.
                """.trimIndent(),
                "Serial, Epic, Tragedy, Action, Fantasy television, Action fiction, Drama, Suspense, Medieval fantasy, Thriller, Adventure, Special Interest",
                "Northern Ireland Dan Iceland",
                "73 Episode",
                "https://s4.bukalapak.com/uploads/content_attachment/9ef1d7fc30e8d7627da004c5/w-744/tv_series_terbaik_-1.jpg"
            )
        )

        tvShow.add(
            TvShowEntity(
                "T5",
                "Game of Thrones",
                "April 17, 2011",
                "Rate Tinggi",
                """
                    Game of Throne bisa dibilang sebagai tv series terbaik dalam satu dekade terakhir. Hal itu dirasa tidak berlebihan, karena tv series garapan David Bennioff dan D.B. Weiss sukses merebut perhatian jutaan orang di seluruh dunia. Terbukti serial tv ini sukses mendapatkan rating tertinggi di situs IMDB, yaitu 9,5.
                    Secara garis besar, tv series ini berkisah tentang perebutan tahta kekuasaan diantara para keluarga. Bahkan mereka sampai mempertaruhkan nyawa untuk mendapatkan tahta yang mereka idam-idamkan.
                    Jalan cerita yang kompleks, imajinasi cerita liar, dan eksekusi apik membuat tv series yang dibintangi oleh Emilia Clarke, Kit Harrington, Sophie Turner, dan Lena Headey ini pantas menerima predikat tv series terbaik.
                    Bulan April mendatang, tv series yang diangkat dari novel berjudul A Song of Ice and Fire ini akan mencapai di musim ke-8, yang merupakan musim terakhir dari Game of Thrones. Jadi jika kamu belum menyaksikan tv series ini, kamu bisa marathon Game of Thrones sampai sebelum berkahirnya perjalanan Jon Snow.
                """.trimIndent(),
                "Serial, Epic, Tragedy, Action, Fantasy television, Action fiction, Drama, Suspense, Medieval fantasy, Thriller, Adventure, Special Interest",
                "Northern Ireland Dan Iceland",
                "73 Episode",
                "https://s4.bukalapak.com/uploads/content_attachment/9ef1d7fc30e8d7627da004c5/w-744/tv_series_terbaik_-1.jpg"
            )
        )

        tvShow.add(
            TvShowEntity(
                "T6",
                "Game of Thrones",
                "April 17, 2011",
                "Rate Tinggi",
                """
                    Game of Throne bisa dibilang sebagai tv series terbaik dalam satu dekade terakhir. Hal itu dirasa tidak berlebihan, karena tv series garapan David Bennioff dan D.B. Weiss sukses merebut perhatian jutaan orang di seluruh dunia. Terbukti serial tv ini sukses mendapatkan rating tertinggi di situs IMDB, yaitu 9,5.
                    Secara garis besar, tv series ini berkisah tentang perebutan tahta kekuasaan diantara para keluarga. Bahkan mereka sampai mempertaruhkan nyawa untuk mendapatkan tahta yang mereka idam-idamkan.
                    Jalan cerita yang kompleks, imajinasi cerita liar, dan eksekusi apik membuat tv series yang dibintangi oleh Emilia Clarke, Kit Harrington, Sophie Turner, dan Lena Headey ini pantas menerima predikat tv series terbaik.
                    Bulan April mendatang, tv series yang diangkat dari novel berjudul A Song of Ice and Fire ini akan mencapai di musim ke-8, yang merupakan musim terakhir dari Game of Thrones. Jadi jika kamu belum menyaksikan tv series ini, kamu bisa marathon Game of Thrones sampai sebelum berkahirnya perjalanan Jon Snow.
                """.trimIndent(),
                "Serial, Epic, Tragedy, Action, Fantasy television, Action fiction, Drama, Suspense, Medieval fantasy, Thriller, Adventure, Special Interest",
                "Northern Ireland Dan Iceland",
                "73 Episode",
                "https://s4.bukalapak.com/uploads/content_attachment/9ef1d7fc30e8d7627da004c5/w-744/tv_series_terbaik_-1.jpg"
            )
        )

        tvShow.add(
            TvShowEntity(
                "T7",
                "Game of Thrones",
                "April 17, 2011",
                "Rate Tinggi",
                """
                    Game of Throne bisa dibilang sebagai tv series terbaik dalam satu dekade terakhir. Hal itu dirasa tidak berlebihan, karena tv series garapan David Bennioff dan D.B. Weiss sukses merebut perhatian jutaan orang di seluruh dunia. Terbukti serial tv ini sukses mendapatkan rating tertinggi di situs IMDB, yaitu 9,5.
                    Secara garis besar, tv series ini berkisah tentang perebutan tahta kekuasaan diantara para keluarga. Bahkan mereka sampai mempertaruhkan nyawa untuk mendapatkan tahta yang mereka idam-idamkan.
                    Jalan cerita yang kompleks, imajinasi cerita liar, dan eksekusi apik membuat tv series yang dibintangi oleh Emilia Clarke, Kit Harrington, Sophie Turner, dan Lena Headey ini pantas menerima predikat tv series terbaik.
                    Bulan April mendatang, tv series yang diangkat dari novel berjudul A Song of Ice and Fire ini akan mencapai di musim ke-8, yang merupakan musim terakhir dari Game of Thrones. Jadi jika kamu belum menyaksikan tv series ini, kamu bisa marathon Game of Thrones sampai sebelum berkahirnya perjalanan Jon Snow.
                """.trimIndent(),
                "Serial, Epic, Tragedy, Action, Fantasy television, Action fiction, Drama, Suspense, Medieval fantasy, Thriller, Adventure, Special Interest",
                "Northern Ireland Dan Iceland",
                "73 Episode",
                "https://s4.bukalapak.com/uploads/content_attachment/9ef1d7fc30e8d7627da004c5/w-744/tv_series_terbaik_-1.jpg"
            )
        )

        tvShow.add(
            TvShowEntity(
                "T8",
                "Game of Thrones",
                "April 17, 2011",
                "Rate Tinggi",
                """
                    Game of Throne bisa dibilang sebagai tv series terbaik dalam satu dekade terakhir. Hal itu dirasa tidak berlebihan, karena tv series garapan David Bennioff dan D.B. Weiss sukses merebut perhatian jutaan orang di seluruh dunia. Terbukti serial tv ini sukses mendapatkan rating tertinggi di situs IMDB, yaitu 9,5.
                    Secara garis besar, tv series ini berkisah tentang perebutan tahta kekuasaan diantara para keluarga. Bahkan mereka sampai mempertaruhkan nyawa untuk mendapatkan tahta yang mereka idam-idamkan.
                    Jalan cerita yang kompleks, imajinasi cerita liar, dan eksekusi apik membuat tv series yang dibintangi oleh Emilia Clarke, Kit Harrington, Sophie Turner, dan Lena Headey ini pantas menerima predikat tv series terbaik.
                    Bulan April mendatang, tv series yang diangkat dari novel berjudul A Song of Ice and Fire ini akan mencapai di musim ke-8, yang merupakan musim terakhir dari Game of Thrones. Jadi jika kamu belum menyaksikan tv series ini, kamu bisa marathon Game of Thrones sampai sebelum berkahirnya perjalanan Jon Snow.
                """.trimIndent(),
                "Serial, Epic, Tragedy, Action, Fantasy television, Action fiction, Drama, Suspense, Medieval fantasy, Thriller, Adventure, Special Interest",
                "Northern Ireland Dan Iceland",
                "73 Episode",
                "https://s4.bukalapak.com/uploads/content_attachment/9ef1d7fc30e8d7627da004c5/w-744/tv_series_terbaik_-1.jpg"
            )
        )

        tvShow.add(
            TvShowEntity(
                "T9",
                "Game of Thrones",
                "April 17, 2011",
                "Rate Tinggi",
                """
                    Game of Throne bisa dibilang sebagai tv series terbaik dalam satu dekade terakhir. Hal itu dirasa tidak berlebihan, karena tv series garapan David Bennioff dan D.B. Weiss sukses merebut perhatian jutaan orang di seluruh dunia. Terbukti serial tv ini sukses mendapatkan rating tertinggi di situs IMDB, yaitu 9,5.
                    Secara garis besar, tv series ini berkisah tentang perebutan tahta kekuasaan diantara para keluarga. Bahkan mereka sampai mempertaruhkan nyawa untuk mendapatkan tahta yang mereka idam-idamkan.
                    Jalan cerita yang kompleks, imajinasi cerita liar, dan eksekusi apik membuat tv series yang dibintangi oleh Emilia Clarke, Kit Harrington, Sophie Turner, dan Lena Headey ini pantas menerima predikat tv series terbaik.
                    Bulan April mendatang, tv series yang diangkat dari novel berjudul A Song of Ice and Fire ini akan mencapai di musim ke-8, yang merupakan musim terakhir dari Game of Thrones. Jadi jika kamu belum menyaksikan tv series ini, kamu bisa marathon Game of Thrones sampai sebelum berkahirnya perjalanan Jon Snow.
                """.trimIndent(),
                "Serial, Epic, Tragedy, Action, Fantasy television, Action fiction, Drama, Suspense, Medieval fantasy, Thriller, Adventure, Special Interest",
                "Northern Ireland Dan Iceland",
                "73 Episode",
                "https://s4.bukalapak.com/uploads/content_attachment/9ef1d7fc30e8d7627da004c5/w-744/tv_series_terbaik_-1.jpg"
            )
        )

        tvShow.add(
            TvShowEntity(
                "T10",
                "Game of Thrones",
                "April 17, 2011",
                "Rate Tinggi",
                """
                    Game of Throne bisa dibilang sebagai tv series terbaik dalam satu dekade terakhir. Hal itu dirasa tidak berlebihan, karena tv series garapan David Bennioff dan D.B. Weiss sukses merebut perhatian jutaan orang di seluruh dunia. Terbukti serial tv ini sukses mendapatkan rating tertinggi di situs IMDB, yaitu 9,5.
                    Secara garis besar, tv series ini berkisah tentang perebutan tahta kekuasaan diantara para keluarga. Bahkan mereka sampai mempertaruhkan nyawa untuk mendapatkan tahta yang mereka idam-idamkan.
                    Jalan cerita yang kompleks, imajinasi cerita liar, dan eksekusi apik membuat tv series yang dibintangi oleh Emilia Clarke, Kit Harrington, Sophie Turner, dan Lena Headey ini pantas menerima predikat tv series terbaik.
                    Bulan April mendatang, tv series yang diangkat dari novel berjudul A Song of Ice and Fire ini akan mencapai di musim ke-8, yang merupakan musim terakhir dari Game of Thrones. Jadi jika kamu belum menyaksikan tv series ini, kamu bisa marathon Game of Thrones sampai sebelum berkahirnya perjalanan Jon Snow.
                """.trimIndent(),
                "Serial, Epic, Tragedy, Action, Fantasy television, Action fiction, Drama, Suspense, Medieval fantasy, Thriller, Adventure, Special Interest",
                "Northern Ireland Dan Iceland",
                "73 Episode",
                "https://s4.bukalapak.com/uploads/content_attachment/9ef1d7fc30e8d7627da004c5/w-744/tv_series_terbaik_-1.jpg"
            )
        )

        return tvShow
    }

}