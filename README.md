# meta-freescale-vmx
Freescale Yocto Project Community BSP

# Getting the BSP

To get the BSP you need to have `repo` installed and use it as:

## Install the `repo` utility:
    mkdir ~/workdir/bin
    curl http://commondatastorage.googleapis.com/git-repo-downloads/repo  > ~/workdir/bin/repo
    chmod a+x ~/workdir/bin/repo
    PATH=${PATH}:~/workdir/bin

## Download the BSP Yocto Project Environment
    mkdir -pv ~/workdir/vmx/yocto/fsl-community-bsp
    cd ~/workdir/vmx/yocto/fsl-community-bsp
    repo init -u https://github.com/Freescale/fsl-community-bsp-platform -b rocko

## Add tinyrex support  
    mkdir -pv .repo/local_manifests/
    cat > .repo/local_manifests/vmx.xml << EOF
    <?xml version="1.0" encoding="UTF-8"?>
    <manifest>
    
      <remote fetch="git://github.com/Voipac" name="voipac"/>
    
      <project remote="voipac" revision="meta-freescale-vmx-rocko" name="yocto-vmx" path="sources/meta-freescale-vmx">
        <copyfile src="vmx-setup.sh" dest="vmx-setup.sh"/>
      </project>
    </manifest>
    EOF

## Sync repositories
    repo sync

## Add Voipac meta layer into BSP
    source vmx-setup.sh
    patch -p1 < sources/meta-freescale-vmx/meta-freescale_recipes-bsp_barebox_barebox_inc.patch

# Building images
    cd ~/workdir/vmx/yocto/fsl-community-bsp

## Supported machines <machine name>
    vmx25

## Supported Freescale's distros <distro name>
    fslc-framebuffer
    fslc-wayland
    fslc-x11
    fslc-xwayland

## Supported Poky's distros <distro name>
    poky-bleeding
    poky
    poky-lsb
    poky-tiny

## Setup and Build Console image
    MACHINE=<machine name> DISTRO=<distro name> source ./setup-environment build-dir
    MACHINE=<machine name> bitbake core-image-base

## Setup and Build Toolchain    
    MACHINE=<machine name> bitbake core-image-base -c populate_sdk
