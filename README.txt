Modders的源代码安装信息
-------------------------------------------
这份代码遵循Minecraft Forge的安装方法。它将对原始MCP源代码应用一些小补丁，以便您和它可以访问构建成功所需的一些数据和函数。

请注意，这些补丁是针对“未重命名”的MCP源代码（即SRG名称）构建的-这意味着您将无法直接针对普通代码读取它们。

设置过程:
==============================
步骤1：打开命令行并浏览到您提取zip文件的文件夹。

步骤2：你需要做出选择。
如果您喜欢使用Eclipse：
运行以下命令：gradlew genEclipseRuns (./gradlew genEclipseRuns如果您在Mac / Linux上)
打开Eclipse，导入>现有的Gradle项目>选择文件夹或运行gradlew eclipse生成项目。

如果您喜欢使用IntelliJ：
打开IDEA，并导入项目。
选择您的build.gradle文件并导入它。
运行以下命令：gradlew genIntellijRuns (./gradlew genIntellijRuns如果您在Mac / Linux上)
如果需要，在IDEA中刷新Gradle项目。
如果在任何时候您在IDE中缺少库，或者遇到问题，您可以运行gradlew --refresh-dependencies以刷新本地缓存。gradlew clean以重置所有内容（不影响您的代码），然后重新开始过程。

映射名称:
=============================
默认情况下，MDK配置为使用Mojang为Minecraft代码库中的方法和字段提供的官方映射名称。这些名称受特定许可证的保护。所有modders都应该知道这个许可证，如果您不同意，可以在build.gradle中将您的映射名称更改为其他集体智慧名称。有关最新的许可证文本，请参阅映射文件本身，或者参考此处的参考副本：
https://github.com/MinecraftForge/MCPConfig/blob/master/Mojang.md

其他资源：
=============================
社区文档：https://mcforge.readthedocs.io/en/latest/gettingstarted/
LexManos的安装视频：https://www.youtube.com/watch?v=8VEdtQLuLO0
Forge论坛：https://forums.minecraftforge.net/
Forge Discord：https://discord.gg/UvedJ9m

GitHub push 失败的命令：
=============================
git config --global http.sslVerify "false"

git config --global --unset http.proxy
git config --global --unset https.proxy
