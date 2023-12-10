package resources

import NativeLocalResource
import com.voitenko.alienworkout.SharedRes
import toNativeLocalResource

public object Videos {
    public val motivation: NativeLocalResource = SharedRes.files.motivation.toNativeLocalResource()
    public val intro: NativeLocalResource = SharedRes.files.intro_2.toNativeLocalResource()
}