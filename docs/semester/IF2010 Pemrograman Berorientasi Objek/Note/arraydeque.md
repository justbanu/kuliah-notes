# ArrayDeque: contoh hasil setiap method
source https://docs.oracle.com/javase/8/docs/api/

Kita pakai **deque awal yang sama untuk setiap baris**:

```text
DEPAN [A, B, A, C] BELAKANG
```

Anggap setiap method dicoba **sendiri-sendiri**, selalu dimulai lagi dari `[A, B, A, C]`. Hasil satu baris tidak diteruskan ke baris berikutnya. `E` di dokumentasi berarti tipe elemennya; di contoh ini `String`. [Rujukan: dokumentasi `ArrayDeque` Java 8](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayDeque.html).

### Menambah elemen

| Panggilan         | Hasil balik        | Deque sesudahnya  |
| ----------------- | ------------------ | ----------------- |
| `add("X")`        | `true`             | `[A, B, A, C, X]` |
| `addFirst("X")`   | tidak ada (`void`) | `[X, A, B, A, C]` |
| `addLast("X")`    | tidak ada          | `[A, B, A, C, X]` |
| `offer("X")`      | `true`             | `[A, B, A, C, X]` |
| `offerFirst("X")` | `true`             | `[X, A, B, A, C]` |
| `offerLast("X")`  | `true`             | `[A, B, A, C, X]` |
| `push("X")`       | tidak ada          | `[X, A, B, A, C]` |

`push("X")` menaruh elemen di **depan**, karena depan dianggap **atas stack**. `add("X")` dan `offer("X")` menaruhnya di **belakang**.

### Melihat tanpa menghapus

Semua panggilan berikut membiarkan deque tetap `[A, B, A, C]`.

| Panggilan       | Hasil balik |
| --------------- | ----------- |
| `element()`     | `"A"`       |
| `getFirst()`    | `"A"`       |
| `getLast()`     | `"C"`       |
| `peek()`        | `"A"`       |
| `peekFirst()`   | `"A"`       |
| `peekLast()`    | `"C"`       |
| `contains("A")` | `true`      |
| `isEmpty()`     | `false`     |
| `size()`        | `4`         |

`peek()` melihat **depan**, sama seperti `peekFirst()`. Saat deque kosong, `peek()` menghasilkan `null`, sedangkan `element()` melempar `NoSuchElementException`.

### Mengambil sekaligus menghapus

| Panggilan       | Hasil balik | Deque sesudahnya |
| --------------- | ----------- | ---------------- |
| `poll()`        | `"A"`       | `[B, A, C]`      |
| `pollFirst()`   | `"A"`       | `[B, A, C]`      |
| `pollLast()`    | `"C"`       | `[A, B, A]`      |
| `pop()`         | `"A"`       | `[B, A, C]`      |
| `remove()`      | `"A"`       | `[B, A, C]`      |
| `removeFirst()` | `"A"`       | `[B, A, C]`      |
| `removeLast()`  | `"C"`       | `[A, B, A]`      |

`pop()` mengambil **depan/atas stack**. `removeLast()` mengambil **belakang/dasar stack**. Di `BrowserHistory`, `removeLast()` cocok untuk membuang halaman paling lama.

### Menghapus berdasarkan isi

Perhatikan ada **dua `"A"`** di contoh.

| Panggilan                    | Hasil balik | Deque sesudahnya |
| ---------------------------- | ----------- | ---------------- |
| `remove("A")`                | `true`      | `[B, A, C]`      |
| `removeFirstOccurrence("A")` | `true`      | `[B, A, C]`      |
| `removeLastOccurrence("A")`  | `true`      | `[A, B, C]`      |
| `clear()`                    | tidak ada   | `[]`             |

`remove("A")` menghapus `"A"` pertama dari arah **depan**. Kalau mencari `"X"` yang tidak ada, ketiga method pencarian itu menghasilkan `false` dan deque tidak berubah.

### Menyalin atau menelusuri isi

Method di bagian ini **tidak mengubah deque asal**.

| Panggilan                | Yang dihasilkan                                      |
| ------------------------ | ---------------------------------------------------- |
| `clone()`                | Salinan deque baru berisi `[A, B, A, C]`             |
| `iterator()`             | Alat untuk membaca berurutan: `A`, `B`, `A`, `C`     |
| `descendingIterator()`   | Alat untuk membaca dari belakang: `C`, `A`, `B`, `A` |
| `spliterator()`          | Alat penelusuran yang juga bisa membagi pekerjaan    |
| `toArray()`              | Array `Object[]` berisi `[A, B, A, C]`               |
| `toArray(new String[0])` | Array `String[]` berisi `[A, B, A, C]`               |

`iterator()` menghasilkan **alat penelusur**, bukan langsung menghasilkan `"A"`. `clone()` adalah method milik `ArrayDeque`; kalau variabelmu bertipe `Deque<String>`, method itu tidak terlihat dari tipe variabelnya.

### Kalau deque kosong

- `peek()`, `peekFirst()`, `peekLast()`, `poll()`, `pollFirst()`, `pollLast()` → menghasilkan `null`.
- `element()`, `getFirst()`, `getLast()`, `pop()`, `remove()`, `removeFirst()`, `removeLast()` → melempar `NoSuchElementException`.
- `isEmpty()` → `true`; `size()` → `0`.
- `ArrayDeque` tidak menerima `null` sebagai elemen. Jadi, `null` dari `peek()` atau `poll()` berarti deque kosong.

Buat soal `BrowserHistory`, pegang empat ini dulu: **`push(current)`** menaruh di atas, **`pop()`** mengambil dari atas, **`removeLast()`** membuang yang paling lama di dasar, dan **`clear()`** mengosongkan riwayat maju.
