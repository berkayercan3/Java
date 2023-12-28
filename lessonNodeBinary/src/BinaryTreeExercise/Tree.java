package BinaryTreeExercise;

public class Tree {
    //ağaç oluşturmaya nasıl başlanır önce bir kök yani root olması lazım
    private Dugum root;

    //App da kullanmak üzere bunu çağıracağım bir yöntemi oluşturmam lazım
    public Tree() { root=null;}     // içerisinee başlangıç değeri olarak kökümü null olarak gönderdim
                                    //artık appda bunu çağırabilirim


    // tree ye ekleme işlemi ile başlanır
    public void insert(long data) //
    {
        Dugum newDugum = new Dugum(); //Dugum sınıfımı kullanarak yeni bir dugum oluşturdum
        newDugum.data = data;     // bu dugume datamı verdım

        if ( root == null)
            root = newDugum;
        else {
            Dugum current = root; // gezici olacak current
            Dugum parent; //parent currentin null olacağı yerde devrede olacak ve null olmadan önceki node dan sonra
                            // newNode oluşturacak ÇAktın?

            while (true) { // while currenti ilerletmek için var
                parent = current; // parenti burada her seferinde currentte eşitliyoruz ki current null olduğunda parent
                                    // devrede olsun
                if (data < current.data) {
                    current = current.LeftChild;
                    if (current == null) {
                        parent.LeftChild = newDugum; //new dugumum datamı içeriyo !
                        return;
                    }
                }
                else{
                    current = current.RightChild;
                    if (current == null){
                        parent.RightChild = newDugum; // current boş kaldığı sırada parent devreye girdi
                        return;
                    }
                }
            }
        }
    }

    public Dugum Find(long data) {
        Dugum current = root;
        while (current.data != data)
        { // eşit olana dek ( bulana dek ) dönecek
            if (data < current.data)
                current = current.LeftChild;
            else  current = current.RightChild; // en sona gelirse ve null olursa ?
            if (current == null)
                return null;
        }
        return current;
    }

    public void Traverse(int traverseType){
        switch (traverseType){
            case 1 -> {
                System.out.print("\n PreOrder: ");
                preOrder(root);
            }
            case 2 -> {
                System.out.print("\n InOrder:");
                inOrder(root);
            }
            case 3 -> {
                System.out.print("\n PostOrder:");
                postOrder(root);
            }
            default -> System.out.print("Yanlis Secim Yapiniz!!");
        }
    }

    public void preOrder(Dugum localRoot){ // kök sol sağ
        if (localRoot != null){
            System.out.print(localRoot.data + " ");
            preOrder(localRoot.LeftChild);
            preOrder(localRoot.RightChild);
        }
    }
    public void inOrder(Dugum localRoot){ // sol kök sağ
        if (localRoot!= null){
            inOrder(localRoot.LeftChild);
            System.out.print(localRoot.data + " ");
            inOrder(localRoot.RightChild);
        }
    }
    public void postOrder(Dugum localRoot){ // sol sağ kök
        if (localRoot != null){
            postOrder(localRoot.LeftChild);
            postOrder(localRoot.RightChild);
            System.out.print(localRoot.data + " ");

        }
    }

    public Dugum minimum(){
        Dugum current = root;
        Dugum parent= null;
        while (current == null){
            parent = current;
            current = current.LeftChild;
        }
        return parent;
    }

    public boolean delete(long key){
        Dugum current = root;
        Dugum parent = root;
        boolean isLeftChild = true; // silinecek değer sol çocuk mu sağ çocuk mu ona bakılır

        // silmek istediğim değeri bulmak için ;
        while(current.data != key)
        {
            parent = current; // current her seferinde değişmeden önce (null olacağı için) parente ataa yapıyoruz
                                // hemde sol düğüm mü sağ düğüm mü silinecek onu buluyoruz
            if (key< current.data){
                isLeftChild = true;
                current = current.LeftChild;
            }else {
                isLeftChild = false;
                current = current.RightChild;
            }
            if (current == null) // aranan değer ağaçta yok
                return false;
        }

        //durum 1 silinecek değerin çocuğu yoksa veya root ise
        if (current.LeftChild == null && current.RightChild==null){
            if (current == root)
                root = null;
            else if(isLeftChild)
                parent.LeftChild = null;
            else parent.RightChild = null;
        }

        // durum 2 silinecek değerin sadece sol çocuğu var ise sağ çocuk yok ise
       else if (current.RightChild==null) {

        }
    }










}
