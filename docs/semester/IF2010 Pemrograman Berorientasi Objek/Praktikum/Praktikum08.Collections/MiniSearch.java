import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MiniSearch {
    private Map<String, Set<Integer>> index = new HashMap<>();    // kata -> id dokumen yang memuat kata itu
    private Map<String, Integer> totalCount = new HashMap<>();    // kata -> total kemunculan di semua dokumen
    private Set<Integer> docs = new HashSet<>();                  // semua id dokumen yang pernah didaftarkan

    public int docCount() {
        return docs.size();
    }

    public int uniqueWords() {
        return index.size();
    }

    // TODO: Daftarkan dokumen dengan id dan isi text.
    // - id selalu dimasukkan ke docs, juga untuk text kosong.
    // - Kata dipisahkan oleh satu atau lebih spasi, dan huruf besar/kecil dianggap sama
    //   (ubah ke huruf kecil). Contoh: "  Java  java JAVA " menghasilkan 3 kemunculan kata "java".
    // - Untuk setiap kata: tambahkan id ke index[kata] dan tambah 1 pada totalCount[kata].
    // - Setiap id dijamin hanya didaftarkan satu kali.
    // Hint: Gunakan method String seperti .trim(), .toLowerCase(), .split("\\s+") (arti regex: one or more whitespace char).
    // Text kosong atau hanya spasi tidak punya kata.
    // https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
    public void indexDocument(int id, String text) {
    }

    // TODO: Kembalikan himpunan id dokumen yang memuat PALING TIDAK SATU kata pada words (union).
    // Kata yang tidak ada di index diabaikan. Huruf besar/kecil dianggap sama.
    // Hasilnya harus set BARU, mengubah hasil ini tidak boleh mengubah isi index.
    public Set<Integer> searchAny(List<String> words) {
        return null;
    }

    // TODO: Kembalikan himpunan id dokumen yang memuat SEMUA kata pada words (irisan).
    // Jika ada satu kata yang tidak ada di index, atau words kosong, hasilnya himpunan kosong.
    // Hasilnya harus set BARU, jangan sampai isi index berubah setelah pencarian.
    // Hint: baca dokumentasi Set.retainAll. Salin dulu set milik index sebelum meng-irisnya.
    public Set<Integer> searchAll(List<String> words) {
        return null;
    }

    // TODO: Kembalikan kata dengan total kemunculan (totalCount) terbesar.
    // Jika ada lebih dari satu kata dengan total sama, pilih yang urutan abjadnya paling awal
    // (gunakan compareTo). Belum ada kata sama sekali -> null.
    public String topWord() {
        return null;
    }
}
