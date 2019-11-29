# Tutorial APAP
## Authors
* **Laila Saffanah** - *1706043531* - *APAP-C*

## Tutorial 9
### What I have learned today 
1. Ceritakan langkah - langkah yang kalian lakukan untuk solve LATIHAN no.1, dan mengapa kalian melakukan langkah - langkah tersebut?

    Untuk solve latihan no.1 saya menambahkan setState yang akan mengembalikan state untuk atribut nama, nomorTelepon, alamat, dan rating kembali ke state "" setelah sebelumnya memiliki isi. Hal ini dilakukan agar setiap diklik cancel pada form, dan form tambah restoran dibuka kembali, isi nya akan selalu diperbarui menjadi kosong lagi. Berikut screenshotnya..
    ![1](https://github.com/lailasaffa/tutorial-apap/blob/feat/tutorial-9-reactjs/frontend-tutorial9/src/assets/do-11.PNG)

2. Jelaskan fungsi dari async dan await!
    + **async** <br/>
    Async digunakan didalam fungsi untuk agar return value dari fungsi tersebut dapat dibungkus menjadi suatu promise. Dalam hal ini promise akan memiliki empat status: fulfilled, rejected, pending, dan settled.
    + **await**<br/>
    Sementara didalam async function, keyword await digunakan untuk menunggu promise apakah sudah memiliki status resolved atau rejected sebelum melanjutkan baris selanjutnya di fungsi tersebut.

3. Masukkan jawaban dari TODO (Screenshot) pada Component Lifecycle pada pertanyaan ini.
    1. Mengubah Restorans.js menjadi dibawah ini
    ![1](https://github.com/lailasaffa/tutorial-apap/blob/feat/tutorial-9-reactjs/frontend-tutorial9/src/assets/do-1.PNG)
    2. Compile program
    ![1](https://github.com/lailasaffa/tutorial-apap/blob/feat/tutorial-9-reactjs/frontend-tutorial9/src/assets/do-2.PNG)
    3. Tampilan halamana localhost:3000
    ![1](https://github.com/lailasaffa/tutorial-apap/blob/feat/tutorial-9-reactjs/frontend-tutorial9/src/assets/do-3.PNG)
    4. Inspect element, dapat dilihat program akan mengeksekusi render(), kemudian componentDidMount()
    ![1](https://github.com/lailasaffa/tutorial-apap/blob/feat/tutorial-9-reactjs/frontend-tutorial9/src/assets/do-4.PNG)
    5. Menambahkan state isLoading:false
    ![1](https://github.com/lailasaffa/tutorial-apap/blob/feat/tutorial-9-reactjs/frontend-tutorial9/src/assets/do-5.PNG)
    6. Menambahkan loadingHandler() untuk mengganti status isLoading supaya shouldComponentUpdate() dapat dieksekusi untuk return true
    ![1](https://github.com/lailasaffa/tutorial-apap/blob/feat/tutorial-9-reactjs/frontend-tutorial9/src/assets/do-6.PNG)
    7. Dapat dilihat status isLoading akan berubah-ubah, setelah itu shouldComponentUpdate() dieksekusi
    ![1](https://github.com/lailasaffa/tutorial-apap/blob/feat/tutorial-9-reactjs/frontend-tutorial9/src/assets/do-7.PNG)

4. Jelaskan fungsi dari componentDidMount, shouldComponentUpdate, componentDidUpdate, componentWillReceiveProps, componentWillUnmount.
    Notes : Penjelasan harus mencantumkan “kapan fungsi dipanggil” dan “use case apa saja yang biasanya menggunakan lifecycle method tersebut”.
    + **componentDidMount**
    componentDidMount akan dipanggil setelah HTML didalam fungsi render() berhasil diload. Biasanya componentDidMount akan digunakan jika kita ingin render suatu component untuk pertama kali sejak render HTML selesai di load tapi belum dimunculkan. Dengan componentDidMount maka render tersebut akan dimunculkan sekali saja.
    + **shouldComponentUpdate**
    Ketika suatu component di update, shouldComponentUpdate akan dipanggil setelah componentWillReceiveProps, namun sebelum fungsi render(). shouldComponentUpdate akan return true ketika component benar terupdate. Namun, jika component tidak ter update maka shouldComponentUpdate akan return false. Setelah false, maka lifecycle method lain tidak akan dipanggil untuk period update tersebut, termasuk render().
    + **componentWillReceiveProps**
    Fungsi componentWillReceiveProps akan dijalankan sebelum fungsi render(). Fungsi ini akan mengambil argument nextProps, yaitu props yang akan component itu terima. Fungsi componentWillReceiveProps akan menentukan action terhadap argument object nextProps sebelum object tersebut digunakan di fungsi render(). Contoh implementasinya adalah memasukkan sebuah nilai tertinggi ke component number sebelum component tersebut dipass ke render().
    + **componentWillUnmount**
    ...componentWillUnmount akan dipanggil tepat sebelum component diremove dari DOM. Jika component memerlukan metode "clean up", maka componentWillMount seharusnya berisi metod clean up tersebut. 

