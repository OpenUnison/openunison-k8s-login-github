package com.tremolosecurity.unison.k8s.tasks;

import java.util.Map;

import com.tremolosecurity.provisioning.core.ProvisioningException;
import com.tremolosecurity.provisioning.core.User;
import com.tremolosecurity.provisioning.core.WorkflowTask;
import com.tremolosecurity.provisioning.tasks.CustomTask;
import com.tremolosecurity.saml.Attribute;

/**
 * MergeGithubGroups
 */
public class MergeGithubGroups implements com.tremolosecurity.provisioning.util.CustomTask {

    @Override
    public boolean doTask(User user, Map<String, Object> request) throws ProvisioningException {
        

        if (user.getAttribs().get("githubOrgs") != null) {
            user.getGroups().addAll(user.getAttribs().get("githubOrgs").getValues());
        }

        if (user.getAttribs().get("githubTeams") != null) {
            user.getGroups().addAll(user.getAttribs().get("githubTeams").getValues());
        }

        

        return true;
    }

    @Override
    public void init(WorkflowTask user, Map<String, Attribute> request) throws ProvisioningException {

    }

    @Override
    public void reInit(WorkflowTask task) throws ProvisioningException {

    }

    

    
}