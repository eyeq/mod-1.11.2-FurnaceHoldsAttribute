package eyeq.furnaceholdsattribute.asm;

import java.util.Map;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

@IFMLLoadingPlugin.TransformerExclusions("eyeq.furnaceholdsattribute.asm")
public class FurnaceHoldsAttributeLoadingPlugin implements IFMLLoadingPlugin {
    @Override
    public String[] getASMTransformerClass() {
        return new String[]{"eyeq.furnaceholdsattribute.asm.FurnaceHoldsAttributeTransformer"};
    }

    @Override
    public String getModContainerClass() {
        return "eyeq.furnaceholdsattribute.asm.FurnaceHoldsAttributeContainer";
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
    }
}
