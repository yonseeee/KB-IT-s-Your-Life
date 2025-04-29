package ch13.quiz;

public class QuizBox<T extends Content>{
    private Object[] list;
    private int size;

    public QuizBox(){
        list =new Object[5];
        size = 0;
    }

    private void ensureCapacity(){
        if(size>=list.length){
            int newCapacity = list.length*2;//배열 늘리기
            Object[] newElements = new Object[newCapacity];
            for(int i=0; i<size; i++){
                newElements[i] = list[i];
            }
            list = newElements;
        }
    }
    public void add(T content){
        ensureCapacity();
        list[size++]=content;//요소 추가 후에 size 늘리기
    }
//    public void addQuiz(T quiz){
//        list=Arrays.copyOf(list, list.length + 1);
//        list[size] = quiz;
//        size++;
//    }

    public boolean remove(Content content){
        int index=0;
        boolean found=false;
        for(int i=0; i<size; i++){
            if(list[i].equals(content)){
                index = i;
                found=true;
                break;

            }
        }
        if(!found){return false;}

        for(int i=index; i<size-1; i++){
            list[i]=list[i+1];//앞에서부터 뒤의 값을 당겨온다.
        }
        list[size-1]=null;//메모리 누수 방지
        size--;

//        System.out.println("삭제 성공: "+content.getQuestion());
        return true;
    }

    static <T extends Content> void removeFromBox(QuizBox<? super T> box, T quiz){
        box.remove(quiz);
    }
    public void printAll(){
        for(int i=0;i<size;i++){
            T item = (T) list[i];
            System.out.println((i+1)+". "+item.getQuestion());
        }
    }
}
