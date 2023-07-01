<h1>GTA3Script</h1>

Repo for custom GTA SA Cleo Mods and tutorials

---

<h3>Index</h3>

- [Installation and Configuration](#installation-and-configuration)
  - [Installing the gta3sc compiler](#installing-the-gta3sc-compiler)
  - [Installing the VSCode extension for gta3script](#installing-the-vscode-extension-for-gta3script)
- [Basics](#basics)
- [Compiling the sources](#compiling-the-sources)
  - [Command line](#command-line)
  - [By VSCode](#by-vscode)
- [Executing the mods](#executing-the-mods)
- [References](#references)

---

## Installation and Configuration

### Installing the gta3sc compiler

1. Clone the src code in https://github.com/thelink2012/gta3sc

```shell
git clone https://github.com/thelink2012/gta3sc.git
```

2. Fix commands TRUE, RETURN_TRUE and RETURN_FALSE

After some odd update, those keywords stopped working. So, before building add the following lines in `gta3sc/config/gtasa/cleo.xml` **(Inside the \<Command\> tag)**:

```xml
<Command ID="0x485" Name="TRUE"/>
<Command ID="0x485" Name="RETURN_TRUE"/>
<Command ID="0x59a" Name="RETURN_FALSE"/>
```

3. Then go into the folder and build the project:

```shell
cd gta3sc
mkdir build
cd build
cmake ..
make
```

4. In order to make the compiler available globally, and activate the recommended flags, append the following alias in your `.bash_aliases`:

```shell
alias gta3sc="/the/path/to/your/build/gta3sc --config=gtasa --guesser -fbreak-continue -fno-entity-tracking -fcleo --cs"
```

Then, reload it:

```shell
source ~/.bashrc
```

### Installing the VSCode extension for gta3script

In your terminal, type:

```shell
code --install-extension thelink2012.gta3script
```

Then, configure it:

1. At the vscode, type `Ctrl + ,`
2. Search for "*gta3script*" extension configs
3. Set the compiler path "where u've cloned it"
4. Edit the buildflags configuration to:

```json
"gtasa": [
  "--guesser",
  "-fbreak-continue",
  "-fno-entity-tracking",
  "-fcleo",
  "--cs"
]
```

---

## Basics

The script files have the extension `.sc` (**source code**). The custom compiled scripts (cleo mods) have the extension `.cs` (**custom script**), the custom mission compiled scripts `.cm` (**custom mission**) and the multi scripts files `.scm` (**script multifile**)

--- 

## Compiling the sources

### Command line

If you've followed the steps in [this session](#installing-the-gta3sc-compiler), simply do:

```shell
gta3sc my_script.sc
```

### By VSCode

If you've configured the extension properly like shown in [this session](#installing-the-vscode-extension-for-gta3script), press `F6`:

---

## Executing the mods

1. Place all your **.cs** and **.cm** files in the `cleo` directory inside yours GTA SA folder.

2. Start the game.

---

## References

[1] [gta3sc github repo](https://github.com/thelink2012/gta3sc)

[2] [forum mixmods tutorials](https://forum.mixmods.com.br/f141-gta3script-cleo/)
