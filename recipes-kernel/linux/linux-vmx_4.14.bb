# Copyright (C) 2016-2018 Voipac
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux kernel for for Voipac VMX25 SoM Evaluation Kit"
DESCRIPTION = "Linux kernel for for Voipac VMX25 SoM Evaluation Kit."

require recipes-kernel/linux/linux-imx.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "linux-4.14"
LOCALVERSION = "-yocto"
SRCREV = "cb771f20aa9c28b3206a1e21ce72f95db487ac65"
KERNEL_SRC ?= "git://github.com/voipac/linux.git;protocol=git"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH} file://defconfig"

DEFAULT_PREFERENCE = "1"              

COMPATIBLE_MACHINE = "(mx25|vmx25)"
