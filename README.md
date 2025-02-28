# Tutorial APAP
## Authors
* **Laila Saffanah** - *1706043531* - *APAP-C*

## Tutorial 1  
### What I have learned today 
#### Github 
1. Apa itu Issue Tracker? Masalah apa yang dapat diselesaikan dengan Issue Tracker?   
Issue tracker adalah alat yang digunakan secara internal pada Google untuk melakukan track pada bugs dan requests pada produk development.
Issue tracker dapat digunakan untuk menyelesaikan masalah bug pada development ​ 
2. Apa perbedaan dari git merge dan merge --squash? 
Git Merge adalah perintah untuk menggabungkan beberapa branch menjadi satu branch yang sama, sedangkan git merge --squash adalah perintah untuk menggabungkan semua perubahan  dalam setiap branch kedalam branch yang digunakan saat akan melakukan commit

#### Spring 
3. Apa itu library & dependency?  
Library: Kumpulan kode yang sebelumnya telah ditulis, kemudian dapat dipanggil ketika kita menjalankan kode kita
Dependecy: Dependency pada OOP artinya setiap perubahan pada base class juga akan mengubah derived classnya
4. Apa itu Maven? Mengapa kita perlu menggunakan Maven? 
Maven adalah sebuah project management dan comprehension tool. Maven perlu digunakan untuk melakukan built, reporting, dan documentation terhadap sebuah projek
5. Apa alternatif dari Maven? CMake, Gradle, Buck

 ### What I did not understand  
 Saya tidak mengerti bagaimana cara kerja Maven dan Spring Boot pada tutorial kali ini

 ## Tutorial 2
 #### Controller
1. Cobalah untuk menambahkan sebuah restoran dengan mengakses link berikut:
	http://localhost:8080/restoran/add?idRestoran=1&nama=PanyuFC&alamat=Kantin%20Fasilkom&nomorTelepon=14022

	**Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.**
    
	Yang terjadi adalah halaman error WhitePage, karena template untuk add-restoran belum dibuat

 #### View Template
2. Cobalah untuk menambahkan sebuah restoran dengan mengakses link berikut:
	http://localhost:8080/restoran/add?idRestoran=2&nama=KentukuFC&alamat=Kantin%20FIK
	
	**Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.**

	Yang terjadi adalah error Whitelabel Error Page, karena tidak ada parameter alamat, padahal required. 

3. Jika Papa APAP ingin melihat restoran PanyuFC, link apa yang harus diakses?
	http://localhost:8080/restoran/view?idRestoran=1&nama=PanyuFC&alamat=Kantin%20Fasilkom&nomorTelepon=14022

4. Tambahkan 1 contoh restoran lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/restoran/viewall, apa yang akan ditampilkan? 
	1. Melakukan Add Restoran kedua
	![GitHub Logo](https://github.com/lailasaffa/tutorial-apap/blob/feat/tutorial-2-gopud/gopud/images/soal-4-1.PNG)
	2. Akses Halaman ViewAll
	![GitHub Logo](https://github.com/lailasaffa/tutorial-apap/blob/feat/tutorial-2-gopud/gopud/images/soal-4-2.PNG)

 ## Tutorial 3
1. Pada class MenuDb, terdapat method findByRestoranIdRestoran, apakah kegunaan dari method tersebut?<br/>
	Untuk menemukan menu berdasarkan Id Restoran menu tersebut.
2. Pada class RestoranController, jelaskan perbedaan method addRestoranFormPage dan addRestoranSubmit?<br/>
	Terdapat dua macam method untuk melakukan transfer data dari client ke server, yaitu GET dan POST. 
	Pada addRestoranFormPage jenis RequestMethod yang digunakan adalah GET, dimana pada GET request parameternya berada di URL. Ketika mengakses url, maka URL akan mengembalikan form addRestoran. Sedangkan pada addRestoranSubmit RequestMethodnya adalah POST, parameter yang ada di halaman akan di pass ke server untuk menyimpan model restoran baru setelah kita klik submit. 
3. Jelaskan apa kegunaan dari JPA Repository?<br/>
	JPA (Java Persistence API) Repository digunakan untuk persisting objek java kedalam database. JPA juga dapat digunakan untuk mengakses objek, melakukan define pada data, melakukan query data.
4. Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara RestoranModel dan MenuModel dibuat?<br/>
	1. Berikut pada RestoranModel:<br/>
		OneToMany(mappedBy = "restoran", fetch = FetchType.LAZY, cascade=CascadeType.ALL)<br/>
    	private List<MenuModel> listMenu;<br/>
    	Dimana restoran akan memiliki hubungan OneToMany dengan menu. 
    2. Berikut pada MenuModel:<br/>
    	@ManyToOne(fetch = FetchType.EAGER,optional = false)<br/>
    	@JoinColumn(name="restoranId",referencedColumnName = "idRestoran",nullable = false)<br/>
    	@OnDelete(action= OnDeleteAction.CASCADE)<br/>
    	@JsonIgnore<br/>
    	private RestoranModel restoran;<br/>
    	Dimana menu akan memiliki relasi ManyToOne dengan restoran

5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER
	1. **FetchType.LAZY**<br/>
		Kegunaan FetchType.LAZY adalah ketika dua entitas memiliki hubungan seperti OneToMany. Ketika satu entitas menggunakan fecth tipe Lazy,
		maka entitas tersebut akan mengambil atribut entitas lain jika dibutuhkan saja, misalkan menggunakan method getStudent()
	2. **FetchType.EAGER**<br/>
		Sedangkan kegunaan tipe fetch EAGER adalah ketika suatu entitas ingin diakses dari database oleh entitas lain, maka seluruh atribut akan langsung di load tanpa kondisi apapun
	3. **CascadeType.ALL**<br/>
		Kegunaan CascadeType.ALL adalah juga untuk mengelola hubungan antar dua entitas. Dimana ketika ada perubahan pada satu entitas, maka perubahan tersebut harus di cascade kepada entitas lain

 ## Tutorial 4
 1. Jelaskan yang anda pelajari dari melakukan latihan nomor 2,dan jelaskan tahapan bagaimana anda menyelesaikan latihan nomor 2<br/>
    1. Dari latihan nomor 2 saya mempelajari bagaimana fragment pada thymeleaf dapat menjadi dinamis. Saya juga mempelajari bahwa terdapat konsep reusing pada penggunaan Spring. <br/>
    2. Tahapan yang saya kerjakan adalah pertama-tama mendefinisikan variable 'title' pada navbar di fragment.html. Kemudian saya akan melakukan replace pada body title di masing-masing halaman. Kemudian pada controller saya akan memasukkan attribute nama halaman tersebut pada variable "title"<br/>
 2. Jelaskan yang anda pelajari dari latihan nomor 3, dan jelaskan tahapan bagaimana anda menyelesaikan latihan nomor 3 <br/>
    1. Dari latihan nomor 3 saya mempelajari cara menggunakan method POST dengan params. Dari latihan nomer 3 juga saya dapat menghapus dan menambahkan row pada field menu. <br/>
    2. Tahapan yang saya lakukan pertama adalah membuat method addRow dan removeRow pada controller. Kemudian saya akan mengedit template sehingga row dapat ditambah sesuai dengan indexnya.<br/>
 3. Jelaskan perbedaan th:include dan th:replace <br/>
th:include akan melibatkan konten fragment yang ditulis pada host tagnya, sementara th:replace akan mengganti host tag dengan konten fragment yang didefinisikan didalam fragment.html</br>
 4. Jelaskan bagaimana penggunaan th:object beserta tujuannya<br/>
 th:object digunakan dalam tag form, dimana th:object akan mendefinisikan variable yang akan digunakan untuk memanggil objek kedalam form kita

 ## Tutorial 5
1. Jelaskan bagian mana saja dari test yang dibuat pada latihan no 2 adalah given, when, dan and then. <br/>
    ![GitHub Logo](https://github.com/lailasaffa/tutorial-apap/blob/feat/tutorial-5-gopud/gopud/images/tutorial-5-soal-2.PNG)<br/>
    1. **given** : Line 58 termasuk kondisi given karena merupakan inisiasi dari test.<br/>
    2. **when** : Line 59 termasuk kondisi when, karena merupakan apa yang seharusnya di return oleh database ketika ada kondisi given<br/>
    3. **then** : Line 60-63 termasuk kondisi then, karena merupakan hasil dari interaksi yang diharapkan<br/>

2. Jelaskan perbedaan line coverage dan logic coverage. <br/>
    1. Line Coverage<br/>
        Line coverage digunakan untuk mengukur jumlah lines dalam sebuah class yang dicover dengan test cases. Line Coverage akan memberikan total jumlah lines didalam code dan jumlah lines yang di execute oleh tests.
    2. Logic Coverage<br/>
        Logic Coverage digunakan untuk mengukur efektivitas sebuah testing dari segi kualitatif. Logic Coverage akan menentukan apakah test case yang dijalankan dapat men-cover keseluruhan fungsional dari sebuah code.

3. Pada keadaan ideal, apa yang seharusnya dibuat terlebih dahulu, code atau unit test? Mengapa seperti itu? Apa akibatnya jika urutannya dibalik, adakah risiko tak terlihat yang mungkin terjadi? <br/>
    Pada keadaan ideal, sebaiknya melakukan unit test terlebih dahulu atau Test Driven Development, dikarenakan<br/>
    1. Developer akan membuat code yang bersih
    2. Developer akan memiliki target code yang clear, penting untuk digunakan di agile environment
    3. Ketika ada ingin melakukan enhancement pada code, developer akan lebih mudah mengetahui dimana harus melakukannya, dan melakukan test code disaat bersamaan
    4. Fungsionalitas code akan lebih mudah dipahami oleh developer lain<br/>
    Jika dilakukan sebaliknya yaitu code terlebih dahulu sebelum test, umumnya developer akan lebih sulit menentukan arah fungsionalitas yang ingin dicapai dari code tersebut. Sementara resiko yang dapat terjadi adalah developer tidak melakukan handle terhadap special case (error) yang mungkin terjadi ketika penulisan code. Namun dengan melakukan test terlebih dahulu, developer dapat meminimalisir terjadinya error.

4. [Bonus] Jelaskan mengapa pada latihan no 3, main class spring tidak diikutsertakan ke dalam perhitungan coverage? Apa saja yang dapat menyebabkan suatu class dapat di-exclude dari perhitungan code coverage. <br/>
    1. Main class spring tidak diikutsertakan dalam perhitungan coverage karena pada tutorial ini hanya akan dilakukan test pada service dan controller. Bukan pada keseluruhan aplikasi (service, controller, model, dan repository)
    2. Dalam melakukan coverage analysis, kita hanya akan fokus pada class yang akan di cover dengan unit test. Dalam tutorial ini, contohnya adalah class controller dan services. Jika sebuah class tidak dicover dengan unit test, maka perlu untuk melakukan exclude pada class yang tidak related tersebut.

##Perubahan Pada Coverage
1. Method View pada Restoran Controller
    1. Sebelum coverage<br/>
    ![GitHub Logo](https://github.com/lailasaffa/tutorial-apap/blob/feat/tutorial-5-gopud/gopud/images/restoran%20controller%20before.PNG)<br/>
    2. Sesudah coverage<br/>
    ![GitHub Logo](https://github.com/lailasaffa/tutorial-apap/blob/feat/tutorial-5-gopud/gopud/images/restoran%20controller%20after.PNG)<br/>
2. Menu Service 
    1. Sesudah coverage<br/>
    ![GitHub Logo](https://github.com/lailasaffa/tutorial-apap/blob/feat/tutorial-5-gopud/gopud/images/menu%20service%20after.PNG)<br/>

## Tutorial 6
1. Apa itu postman? Apa kegunaan dari postman?<br/>
    Postman adalah sebuah platform untuk API development, Postman digunakan untuk pengguna yang ingin berkolaborasi membuat API. Postman adalah sebuah aplikasi (berupa plugin) untuk browser chrome sebagai REST Client atau istilahnya adalah aplikasi yang digunakan untuk melakukan uji coba REST API yang telah kita buat. Postman adalah tool wajib bagi para developer untuk pembuatan API, fungsi utama postman ini adalah sebagai GUI API Caller sekaligus menyediakan fitur lain yaitu Sharing Collection API for Documentation, Testing API, Realtime Collaboration Team, Monitoring API, dan Integration. Pertamanya Postman muncul sebagai add on dari Chrome namun sekarang sudah menjadi aplikasi native.
2. Apa kegunaan dari annotation @JsonIgnoreProperties? <br/>
    @JsonIgnoreProperties digunakan untuk menekan serialisasi properti (selama serialisasi), atau mengabaikan pemrosesan properti JSON yang dibaca (saat deserialisasi)
3. Apa itu ResponseEntity dan apa kegunaannya<br/>
    ResponseEntity dalam spring akan membuat melakukan set pada body, status dan header pada HTTP response. ResponseEntity mewakili seluruh respons HTTP: kode status, header, dan body. Karena itu, kita dapat menggunakannya untuk mengkonfigurasi respons HTTP sepenuhnya

## Tutorial 7
1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?
    Otentikasi akan menentukan apakah seorang person adalah user atau tidak untuk mengakses sistem. Sementara otorisasi menentukan permission apa yang dimiliki oleh user dalam mengakses sebuah resource didalam sistem.<br/>
    1. Implementasi Otentikasi<br/>
        Implementasi otentikasi dilakukan ketika user melakukan login. Sistem akan menentukan apakah person adalah user dengan method configAuthentication di WebSecurityConfig.java. Autentikasi juga ditentukan menggunakan interface UserDetailsService milik spring security. Menggunakan method loadUserByUsername, sistem akan memvalidasi apakah data person yang dimasukkan ketika login match dengan data user yang dimiliki sistem
    2. Implementasi Otorisasi<br/>
        Implementasi Otorisasi dilakukan setelah user melakukan login dan mendapatkan user role, maka sistem akan menentukan resource dalam sistem apa saja yang dimiliki oleh user. Contohnya di WebSecurityConfig.java, method configure akan menentukan autorisasi apa yang dimiliki user, berdasarkan role nya admin, merchant, atau user. Contoh autorisasinya adalah hanya admin yang dapat menambah user baru dan hanya merchant yang dapat melihat daftar restoran.
2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerjanya!<br/>
    BcryptPasswordEncoder adalah interface yang disediakan oleh Spring Security untuk membuat encoding pada password menggunakan slow hashing algorithm. Karena password di database tidak boleh ditunjukan secara eksplisit, maka penting untuk melakukan encoding password sebelum menampilkannya di database. Interface ini juga dapat digunakan untuk password comparison
3. Jelaskan secara singkat apa itu UUID dan mengapa kita memakai UUID di UserModel.java?
    UUID atau Universally Unique Identifier adalah sebuah 128-bit long value yang unique dan dapat digunakan untuk berbagai keperluan. UUID terdiri dari hex digits dengan 4 char untuk setiap digit bersama dengan 4 "-" simbol. Sehingga total characternya adalah 36.<br/>
    UUID digunakan di UserModel.java agar id yang dihasilkan unique.
4. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut padahal kita sudah memiliki class UserRoleServiceImpl.java?</br>
    UserDetailsServiceImpl.java sebenarnya adalah implementasi dari interface UserDetailsService yang dimiliki spring security. Berbeda dengan UserService atau RoleService yang merupakan implementasi dari interface aplikasi ini sendiri. Kita memerlukan class tersebut untuk menjalankan proses autentikasi. Salah satu methodnya yaitu loadUserByUsername akan mencari tahu apakah person yang melakukan login sudah termasuk user sistem atau belum.

## Tutorial 8
Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi dari apa yang Anda jelaskan.</br>
1. Task: Menghilangkan checkbox pada item di list bagian kiri
    Saya menggunakan approach onItemClick untuk menggantikan checkbox. Ketika item di list menu di klik, maka akan dipindahkan ke list favorite item. Berikut implementasi saya</br>
    ![](https://github.com/lailasaffa/tutorial-apap/blob/feat/tutorial-8-reactjs/frontend/src/Images/1.1.PNG)</br>
    ![](https://github.com/lailasaffa/tutorial-apap/blob/feat/tutorial-8-reactjs/frontend/src/Images/1.2.PNG)</br>
2. Task: Bagian kiri hanya melakukan operasi add
    Saya membuat fungsi handleMenuItem dimana fungsi tersebut akan menambahkan item ke list favorite item. Kemudia pada fungsi handleFavorite Item saya akan menghapus item dari list favorite item tersebut. Berikut implementasi saya</br>
    ![](https://github.com/lailasaffa/tutorial-apap/blob/feat/tutorial-8-reactjs/frontend/src/Images/2.1.PNG)</br>
    ![](https://github.com/lailasaffa/tutorial-apap/blob/feat/tutorial-8-reactjs/frontend/src/Images/2.2.PNG)</br>
3. Task: Membuat toggle jika ON maka favorite list ditampilkan, jika OFF disembunyikan
    Disini saya akan membuat const isFavorite yang awalnya saya set ke false. Kemudian saya membuat fungsi handleFavoriteCheckboxes() untuk mengganti state boolean tersebut. Jika isFavorite false maka bagian favorite akan dikosongkan. Jika isFavorite true maka list favorite akan dimunculkan. Berikut implementasi saya</br>
    ![](https://github.com/lailasaffa/tutorial-apap/blob/feat/tutorial-8-reactjs/frontend/src/Images/3.1.PNG)</br>
    ![](https://github.com/lailasaffa/tutorial-apap/blob/feat/tutorial-8-reactjs/frontend/src/Images/3.2.PNG)</br>
    ![](https://github.com/lailasaffa/tutorial-apap/blob/feat/tutorial-8-reactjs/frontend/src/Images/3.3.PNG)</br>
4. Task: Membuat empty state
    Disini saya membuat sebuah component empty state. Kemudian component tersebut akan saya panggil setelah saya melakukan pengecekan pda length favorite items. Apabila length favorite items = 0, maka saya akan memanggil component empty state tersebut. </br>
    ![](https://github.com/lailasaffa/tutorial-apap/blob/feat/tutorial-8-reactjs/frontend/src/Images/4.1.PNG)</br>
    ![](https://github.com/lailasaffa/tutorial-apap/blob/feat/tutorial-8-reactjs/frontend/src/Images/4.2.PNG)</br>



