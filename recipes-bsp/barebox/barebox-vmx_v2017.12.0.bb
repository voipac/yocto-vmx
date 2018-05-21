require recipes-bsp/barebox/barebox.inc

DESCRIPTION = "barebox for Voipac VMX25 SoM Evaluation Kit."
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"
COMPATIBLE_MACHINE = "(vmx25)"

PROVIDES += "barebox"
DEPENDS += "lzop-native"

PV = "v2017.12.0"

SRCBRANCH = "barebox-v2017.12.0"
SRCREV = "952939fb5e5d29d0eecc582728d6af8b834740ed"
BAREBOX_SRC ?= "git://github.com/voipac/barebox.git;protocol=git"
SRC_URI = "${BAREBOX_SRC};branch=${SRCBRANCH} file://defconfig"

BAREBOX_BINARY = "images/barebox-voipac-vmx25.img" 

S = "${WORKDIR}/git"

LOCALVERSION ?= "-${SRCBRANCH}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE_vmx25 = "vmx25"
