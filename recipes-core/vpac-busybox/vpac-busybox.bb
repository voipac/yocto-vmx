SUMMARY = "Vpac initscript files"
DESCRIPTION = "Various vpac branding files."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r0"

SRC_URI = " \
	file://vpac-logo.sh \
"

S = "${WORKDIR}"

inherit allarch update-rc.d

do_compile () {
}

do_install() {
	install -d ${D}/${sysconfdir}/init.d/
	install -m 0755 ${S}/vpac-logo.sh ${D}/${sysconfdir}/init.d/
}

INITSCRIPT_PACKAGES = "${PN}-logo"
INITSCRIPT_NAME_${PN}-logo = "vpac-logo.sh"
INITSCRIPT_PARAMS_${PN}-logo = "start 99 5 ."

PACKAGES =+ "${PN}-logo"

FILES_${PN}-logo = " \
    ${sysconfdir}/init.d/vpac-logo.sh \
"
