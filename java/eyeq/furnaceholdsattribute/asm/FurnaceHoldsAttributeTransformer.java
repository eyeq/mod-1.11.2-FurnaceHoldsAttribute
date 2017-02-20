package eyeq.furnaceholdsattribute.asm;

import eyeq.furnaceholdsattribute.asm.item.crafting.GetSmeltingResultMethodTransformer;
import eyeq.furnaceholdsattribute.asm.tileentity.CanSmeltMethodTransformer;
import eyeq.util.asm.NodeUtils;
import net.minecraft.launchwrapper.IClassTransformer;

public class FurnaceHoldsAttributeTransformer implements IClassTransformer {
    public final GetSmeltingResultMethodTransformer getSmeltingResult = new GetSmeltingResultMethodTransformer();
    public final CanSmeltMethodTransformer canSmelt = new CanSmeltMethodTransformer();

    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        basicClass = NodeUtils.transform(name, transformedName, basicClass, getSmeltingResult);
        basicClass = NodeUtils.transform(name, transformedName, basicClass, canSmelt);
        return basicClass;
    }
}
