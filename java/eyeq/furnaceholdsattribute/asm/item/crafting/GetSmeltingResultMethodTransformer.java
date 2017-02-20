package eyeq.furnaceholdsattribute.asm.item.crafting;

import eyeq.util.asm.NodeUtils;
import eyeq.util.asm.MethodTransformer;
import net.minecraft.item.ItemStack;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

public class GetSmeltingResultMethodTransformer extends MethodTransformer implements Opcodes {
    public static final String THIS_CLASS_NAME = "eyeq/furnaceholdsattribute/asm/GetSmeltingResultMethodTransformer";

    public static final String TARGET_CLASS_NAME = "net.minecraft.item.crafting.FurnaceRecipes";
    public static final String[] TARGET_METHOD_NAME = {"getSmeltingResult", "func_151395_a"};
    public static final String TARGET_METHOD_DESC = "(Lnet/minecraft/item/ItemStack;)Lnet/minecraft/item/ItemStack;";

    public GetSmeltingResultMethodTransformer() {
        super(TARGET_CLASS_NAME, TARGET_METHOD_NAME, TARGET_METHOD_DESC);
    }

    @Override
    public void transform(MethodNode methodNode) {
        // FurnaceRecipes.getSmeltingResult()
        InsnList overrideList = new InsnList();
        overrideList.add(new VarInsnNode(ALOAD, 1));
        overrideList.add(new MethodInsnNode(INVOKESTATIC, THIS_CLASS_NAME, "getNamedSmeltingResult",
                "(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;)Lnet/minecraft/item/ItemStack;"));

        InsnList insnList = methodNode.instructions;
        AbstractInsnNode location = NodeUtils.getFirst(insnList, ARETURN);
        insnList.insertBefore(location, overrideList);
    }

    public static ItemStack getNamedSmeltingResult(ItemStack result, ItemStack input) {
        if(input.hasDisplayName()) {
            result = result.copy();
            String inputItemStackName = input.getDisplayName();
            String inputItemName = input.getItem().getItemStackDisplayName(input);
            String resultItemName = result.getItem().getItemStackDisplayName(result);
            result.setStackDisplayName(inputItemStackName.replaceAll(inputItemName, resultItemName));
        }
        return result;
    }
}
