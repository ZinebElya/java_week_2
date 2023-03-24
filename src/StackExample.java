import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();

        // Ajouter des éléments à la pile
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Supprimer l'élément en haut de la pile
        int topElement = stack.pop();

        // Accéder à l'élément en haut de la pile
        int peekElement = stack.peek();

        // Vérifier si la pile est vide
        boolean empty = stack.empty();

        // Rechercher un élément dans la pile
        int position = stack.search(20);

        System.out.println("Top Element: " + topElement);
        System.out.println("Peek Element: " + peekElement);
        System.out.println("Empty: " + empty);
        System.out.println("Position of 20: " + position);
    }
}

