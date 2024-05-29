import java.util.*;

public class BuiltInLinkedListTester {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        LinkedList<Integer> list = new LinkedList<>();
        System.out.println(list + " size=" + list.size());

        String option = "";
        do {
            option = displayOptions(console);

            if (option.startsWith("af")) {

                System.out.print("Add what? > ");
                list.add(0, console.nextInt());

            } else if (option.startsWith("ae")) {

                System.out.print("Add what? > ");
                list.add(console.nextInt());

            } else if (option.startsWith("rf")) {

                int removed = list.remove(0);
                System.out.println("Removed " + removed);

            } else if (option.startsWith("re")) {

                int removed = list.remove(list.size() - 1);
                System.out.println("Removed " + removed);

            } else if (option.startsWith("g")) {

                System.out.print("Get what index? > ");
                int got = list.get(console.nextInt());
                System.out.println("Got " + got);

            } else if (option.startsWith("s")) {

                System.out.print("Set what index? > ");
                int index = console.nextInt();
                System.out.print("To what? > ");
                int value = console.nextInt();
                list.set(index, value);

            } else if (option.startsWith("ai")) {

                System.out.print("Add at what index? > ");
                int index = console.nextInt();
                System.out.print("Add what? > ");
                int value = console.nextInt();
                list.add(index, value);

            } else if (option.startsWith("ri")) {

                System.out.print("Remove what index? > ");
                int removed = list.remove(console.nextInt());
                System.out.println("Removed " + removed);

            } else if (option.startsWith("co")) {

                System.out.print("Contains what? > ");
                System.out.println(list.contains(console.nextInt()));

            }

            System.out.println(list + " size=" + list.size());

        } while (!option.startsWith("d"));
    }

    public static String displayOptions(Scanner console) {

        System.out.println("\nOptions: (af) add to front (ae) add to end (rf) remove front (re) remove end (co) contains ");
        System.out.println("         (g) get by index (s) set by index (ai) add at index (ri) remove at index (d) done");
        System.out.print("Pick an action > ");
        return console.next().toLowerCase();

    }
}