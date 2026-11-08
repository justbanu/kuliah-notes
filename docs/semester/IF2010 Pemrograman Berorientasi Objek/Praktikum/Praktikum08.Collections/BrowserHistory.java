import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserHistory {
    // Dua Stack berbasis Deque. Elemen paling atas adalah elemen paling baru.
    private Deque<String> backStack = new ArrayDeque<>();      // halaman-halaman sebelumnya
    private Deque<String> forwardStack = new ArrayDeque<>();   // halaman-halaman yang bisa di-forward
    private String current;
    private int limit;                                         // batas isi backStack (limit >= 1)

    public BrowserHistory(String homepage, int limit) {
        this.current = homepage;
        this.limit = limit;
    }

    public String current() {
        return current;
    }

    public int backCount() {
        return backStack.size();
    }

    public int forwardCount() {
        return forwardStack.size();
    }

    // TODO: Buka halaman baru.
    // 1. Halaman yang sedang dibuka masuk ke backStack (taruh di atas tumpukan).
    // 2. forwardStack dikosongkan (riwayat "maju" hilang saat membuka halaman baru).
    // 3. current menjadi page.
    // 4. Jika isi backStack melebihi limit, buang halaman PALING LAMA (yang ada di dasar tumpukan).
    // Hint: baca dokumentasi Deque / ArrayDeque untuk method yang memperlakukannya sebagai stack,
    // serta method yang membuang elemen dari ujung yang berlawanan.
    public void visit(String page) {
        backStack.push(current);
        forwardStack.clear();
        current = page;

        if(backStack.size() > limit){
            backStack.removeLast();
        }

    }

        // TODO: Kembali satu halaman.
        // Jika backStack kosong, tidak ada yang berubah, kembalikan current.
        // Jika tidak, halaman yang sedang dibuka masuk ke forwardStack, current menjadi halaman teratas
        // backStack (ambil dari tumpukan). Kembalikan current yang baru.
        public String back() {
            if(backStack.isEmpty()){
                return current;
            }
            forwardStack.push(current);
            current = backStack.pop();
            return current;
        }

    // TODO: Maju satu halaman. Kebalikan dari back().
    // Jika forwardStack kosong, tidak ada yang berubah, kembalikan current.
    // Jika tidak, halaman yang sedang dibuka masuk ke backStack, current menjadi halaman teratas
    // forwardStack (ambil dari tumpukan). Kembalikan current yang baru.
    public String forward() {
        if(forwardStack.isEmpty()){
            return current;
        }
        backStack.push(current);
        current = forwardStack.pop();
        return current;
    }
}