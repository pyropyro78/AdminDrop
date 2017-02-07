package com.pyromanticgaming.admindrop;

/*
*Copyright (c) <2017>, <pyropyro78>, <pyropyro78@gmail.com>
*All rights reserved.
*
*THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

public class MainConfig {
	
	private static AdminDrop plugin;
	
	public MainConfig(AdminDrop instance) {
		plugin = instance;
	}
	
	public static long SaveTimer = 200;
	public static boolean enderchestitem, chestitem, pickupmessagetoggle, throwmessagetoggle, chestmessagetoggle, dropmessagetoggle;
	public static String dropmessage, chestmessage, throwmessage, pickupmessage;
	
	public static void GetMainValues() {
		
		SaveTimer = plugin.getConfig().getLong("SaveTimer");
		chestitem = plugin.getConfig().getBoolean("ChestItem");
		pickupmessagetoggle = plugin.getConfig().getBoolean("PickUpMessageToggle");
		throwmessagetoggle = plugin.getConfig().getBoolean("ThrowMessageToggle");
		chestmessagetoggle = plugin.getConfig().getBoolean("ChestMessageToggle");
		dropmessagetoggle = plugin.getConfig().getBoolean("DropMessageToggle");
		enderchestitem = plugin.getConfig().getBoolean("EnderChest");
		dropmessage = plugin.getConfig().getString("DropMessage");
		chestmessage = plugin.getConfig().getString("ChestMessage");
		throwmessage = plugin.getConfig().getString("ThrowMessage");
		pickupmessage = plugin.getConfig().getString("PickUpMessage");
	}


}