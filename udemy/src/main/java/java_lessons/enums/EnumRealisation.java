//package java_lessons.enums;
//
///**
// * ENUM REALISATION!
// * По сути, Enum - это класс!
// *
// * Inner realisation of Enum!
// *
// * All Enum extends something like this:
// *
// * abstract class Enum<E extends Enum<E>> implements Comparable<E>, Serializable {
// *     private final String name;
// *     private final int ordinal;
// *
// *     protected Enum(String name, int ordinal) {
// *         this.name = name;
// *         this.ordinal = ordinal;
// *
// *         and etc...
// *     }
// * }
// *
// * for more information see this: package java.lang.Enum;
// */
//final class EnumRealisation extends Enum {
//
//    public static final EnumRealisation MONDAY;
//    public static final EnumRealisation TUESDAY;
//    public static final EnumRealisation WEDNESDAY;
//
//    private static final EnumRealisation $VALUES[];
//
//    static {
//        MONDAY = new EnumRealisation("MONDAY", 0);
//        TUESDAY = new EnumRealisation("TUESDAY", 1);
//        WEDNESDAY = new EnumRealisation("WEDNESDAY", 2);
//        $VALUES = (new EnumRealisation[] {
//                MONDAY, TUESDAY, WEDNESDAY
//        });
//    }
//
//    public static EnumRealisation[] values() {
//        return (EnumRealisation[])$VALUES.clone();
//    }
//
//    public static EnumRealisation valueOf(String s) {
//        return (EnumRealisation) Enum.valueOf(EnumRealisation.class, s);
//    }
//
//    /**
//     * Sole constructor.  Programmers cannot invoke this constructor.
//     * It is for use by code emitted by the compiler in response to
//     * enum type declarations.
//     *
//     * @param name    - The name of this enum constant, which is the identifier
//     *                used to declare it.
//     * @param ordinal - The ordinal of this enumeration constant (its position
//     *                in the enum declaration, where the initial constant is assigned
//     */
//    protected EnumRealisation(String name, int ordinal) {
//        super(name, ordinal);
//    }
//}
