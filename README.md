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
	Format: ![Alt Text](url)
	2. Akses Halaman ViewAll
	![GitHub Logo](https://github.com/lailasaffa/tutorial-apap/blob/feat/tutorial-2-gopud/gopud/images/soal-4-2.PNG)
	Format: ![Alt Text](url)

