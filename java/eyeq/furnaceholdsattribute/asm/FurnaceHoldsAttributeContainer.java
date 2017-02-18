package eyeq.furnaceholdsattribute.asm;

import java.util.Collections;

import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.versioning.DefaultArtifactVersion;

import com.google.common.eventbus.EventBus;

public class FurnaceHoldsAttributeContainer extends DummyModContainer {
    public static final String MOD_ID = "eyeq_furnaceholdsattribute";

    public FurnaceHoldsAttributeContainer() {
        super(new ModMetadata());

        ModMetadata meta = getMetadata();
        meta.modId = MOD_ID;
        meta.name = "FurnaceHoldsAttribute";
        meta.description = "名前継承精錬";
        meta.version = "1.0";
        meta.authorList = Collections.singletonList("eyeq");
        meta.dependencies = Collections.singletonList(new DefaultArtifactVersion("eyeq_util"));
        meta.useDependencyInformation = true;
    }

    @Override
    public boolean registerBus(EventBus bus, LoadController controller) {
        bus.register(this);
        return true;
    }
}
