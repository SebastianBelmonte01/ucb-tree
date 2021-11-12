package bo.edu.ucb.est;

public class Tree<D extends Comparable<D>> {
    private Node root;

    public Tree() {
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void add(D data) {
        Node newNode = new Node(data);
        if ( root == null) { // arbol vacio
            root = newNode;
        } else {
            Node<D> current = root;
            while(current != null ) {
                if (current.getData().compareTo(data) > 0) {
                    if (current.getLeft() == null) { // Tengo el espacio vacio para agregar el nodo
                        current.setLeft(newNode);
                        break; // Terminamos el recorrido
                    } else { // continuo bajando por la rama izquierda
                        current = current.getLeft();
                    }
                } else if (current.getData().compareTo(data) < 0) {
                    if (current.getRight() == null) { // Tengo el espacio vacio para agregar el nodo
                        current.setRight(newNode);
                        break; // Terminamos el recorrido
                    } else { // continuo bajando por la rama derecha
                        current = current.getRight();
                    }
                } else { // igual a cero
                    // Entonces el elemento ya existe.
                    throw new RuntimeException("No se puede agregar elementos duplicados a un ABB");
                }

            }
        }
    }

    public static void printInOrder(Node<?> root) {
//        Hasta que todos los nodos hayan sido atravesados −
//        Paso 1 − Recorre recursivamente el subarbol izquierdo.
//        Paso 2 − Visitamos el nodo raíz.
//        Paso 3 − Recorre recursivamente el subarbol derecho.

         //  4 5 6  7

        if(root != null){
            printInOrder(root.getLeft());
            System.out.print(root.getData() +", ");
            printInOrder(root.getRight());
        }


    }
    public static void printPreOrder(Node <?> root){
        //5 4 6 7
        if(root != null){
            System.out.print(root.getData() +", ");
            printInOrder(root.getLeft());
            printInOrder(root.getRight());
        }
    }
    public static void printPostOrder(Node<?> root){
        //4 6 7 5
        if(root != null){
            printInOrder(root.getLeft());
            printInOrder(root.getRight());
            System.out.print(root.getData() +", ");
        }

    }
}
