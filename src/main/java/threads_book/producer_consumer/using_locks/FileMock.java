package threads_book.producer_consumer.using_locks;

/**
 * Created by sharath on 3/29/15.
 */
public class FileMock {
    private String[] content;
    private int index;

    public FileMock(int size, int length) {
        this.content = new String[size];
        for(int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder(length);
            for(int j = 0; j < length; j++) {
                int indice = (int)Math.random()*255;
                sb.append((char)indice);
            }
            content[i] = sb.toString();
        }
        this.index = 0;
    }

    public boolean hasMoreLines() {
        return index < content.length;
    }

    public String getLine() {
        if(this.hasMoreLines()) {
            System.out.println("Mock: "+(content.length-index));
            return content[index++];
        }
        return null;
    }
}
