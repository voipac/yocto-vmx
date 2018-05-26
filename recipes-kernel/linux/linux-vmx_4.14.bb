# Copyright (C) 2016 Voipac
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux kernel for for Voipac VMX25 SoM Evaluation Kit"
DESCRIPTION = "Linux kernel for for Voipac VMX25 SoM Evaluation Kit."

require recipes-kernel/linux/linux-imx.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "linux-4.14"
LOCALVERSION = "-yocto"
SRCREV = "4a31b3df364d282eab49a24255894ec09b84286f"
KERNEL_SRC ?= "git://github.com/voipac/linux.git;protocol=git"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH} file://defconfig"

DEFAULT_PREFERENCE = "1"              

COMPATIBLE_MACHINE = "(mx25|vmx25)"
