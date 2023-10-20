SUMMARY = "Infineon/Cypress/Broadcom Patchram Plus utility"
SECTION = "Wireless"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=691691b063f1b4034300dc452e36b68d"

inherit pkgconfig

SRC_URI = "git://github.com/LairdCP/brcm_patchram.git;protocol=https"

SRCREV = "2a74311ed7b26ffada931fdf0be1f62930c7ba33"

S = "${WORKDIR}/git"

DEPENDS += "${@bb.utils.contains('DISTRO_FEATURES','bluez5','bluez5','bluez4',d)}"

RRECOMMENDS:${PN} = "kernel-module-lwb-if-backports"

do_compile () {
	oe_runmake brcm_patchram_plus
}

do_install () {
	install -d ${D}${sbindir}
	install -m 755 brcm_patchram_plus ${D}${sbindir}
}
