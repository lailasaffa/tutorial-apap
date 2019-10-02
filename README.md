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
