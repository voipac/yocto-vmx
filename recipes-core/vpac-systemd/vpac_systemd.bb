SUMMARY = "Vpac initscript files"
DESCRIPTION = "Various vpac branding files."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r0"

SRC_URI = " \
	file://vpac-logo.sh \
	file://vpac-logo.service \
"

S = "${WORKDIR}"

do_compile () {
}

do_install() {
	install -d ${D}/${sbindir}
	install -m 0755 ${S}/vpac-logo.sh ${D}/${sbindir}

	install -d ${D}/${systemd_unitdir}/system/
	install -m 0644 ${S}/vpac-logo.service ${D}/${systemd_unitdir}/system
}

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "vpac-logo.service"

inherit allarch systemd
