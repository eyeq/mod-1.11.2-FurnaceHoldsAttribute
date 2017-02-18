package eyeq.furnaceholdsattribute.asm;

import eyeq.util.asm.NodeUtils;
import eyeq.util.asm.MethodTransformer;
import net.minecraft.item.ItemStack;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

public class CanSmeltMethodTransformer extends MethodTransformer implements Opcodes {
    public static final String THIS_CLASS_NAME = "eyeq/furnaceholdsattribute/asm/CanSmeltMethodTransformer";
    public static final String TARGET_CLASS_NAME = "net.minecraft.tileentity.TileEntityFurnace";
    public static final String TARGET_METHOD_NAME[] = {"canSmelt", "func_145948_k"};
    public static final String TARGET_METHOD_DESC = "()Z";

    public CanSmeltMethodTransformer() {
        super(TARGET_CLASS_NAME, TARGET_METHOD_NAME, TARGET_METHOD_DESC);
    }

    @Override
    public void transform(MethodNode methodNode) {
        //TileEntityFurnace.canSmelt()
        InsnList overrideList = new InsnList();
        overrideList.add(new VarInsnNode(ALOAD, 1));
        overrideList.add(new VarInsnNode(ALOAD, 2));
        overrideList.add(new MethodInsnNode(INVOKESTATIC, THIS_CLASS_NAME, "equalsDisplayName",
                "(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;)Z"));
        LabelNode label = new LabelNode();
        overrideList.add(new JumpInsnNode(IFNE, label));
        overrideList.add(new InsnNode(ICONST_0));
        overrideList.add(new InsnNode(IRETURN));
        overrideList.add(label);

        InsnList insnList = methodNode.instructions;
        AbstractInsnNode location = NodeUtils.getLast(insnList, IRETURN);
        insnList.insertBefore(location, overrideList);
    }

    public static boolean equalsDisplayName(ItemStack itemStack0, ItemStack itemStack1) {
        if(itemStack0.hasDisplayName() != itemStack0.hasDisplayName()) {
            return false;
        }
        return itemStack0.getDisplayName().equals(itemStack1.getDisplayName());
    }
}
