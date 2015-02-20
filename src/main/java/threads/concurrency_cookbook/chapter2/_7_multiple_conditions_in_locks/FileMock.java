package threads.concurrency_cookbook.chapter2._7_multiple_conditions_in_locks;

/**
 * Created by sharath on 2/2/15.
 */
public class FileMock {
    private String[] content;
    private int index;

    public FileMock(int size, int length) {
        this.content = new String[size];
        for(int i = 0; i < size; i++) {
            StringBuffer sb = new StringBuffer(length);
            for (int j = 0; j < length; j++) {
                int indice = (int)Math.random()*255;
                sb.append((char)indice);
            }
            content[i] = sb.toString();
        }
        index = 0;
    }

    public boolean hasMoreLines() {
        return index < content.length;
    }

    public String getLine() {
        if(this.hasMoreLines()) {
            System.out.printf("Mock: %d\n", content.length - index);
            return content[index++];
        }
        return null;
    }
}
